package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.CoinAPIExternal;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiExternalSummary;
import com.co.indra.coinmarketcap.coins.model.responses.ErrorResponse;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CoinControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void createCoinHappyPath() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/coins")
                .content("{\n" +
                        "    \"idSymbolCoin\": \"BIT\",\n" +
                        "    \"nameCoin\": \"Bitcoin\",\n" +
                        "    \"iconCoin\": \"www.image.com\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());

        List<Coin> coin = coinRepository.findCoinByIdSymbolCoin("BIT");
        Assertions.assertEquals(1, coin.size());

        Coin coinToAssert = coin.get(0);
        Assertions.assertEquals("BIT", coinToAssert.getIdSymbolCoin());
        Assertions.assertEquals("Bitcoin", coinToAssert.getNameCoin());
        Assertions.assertEquals("www.image.com", coinToAssert.getIconCoin());
    }

    @Test
    public void createCoinBadPath() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/coins")
                .content("{\n" +
                        "    \"idSymbolCoin\": \"BIt\",\n" +
                        "    \"nameCoin\": \"Bitcoin\",\n" +
                        "    \"iconCoin\": \"www.image.com\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(400, response.getStatus());
    }

    @Test
    public void createCoinAlreadyExistPath() throws Exception {
        coinRepository.create(new Coin("BIT", "Bitcoin", "www.image.com"));
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/coins")
                .content("{\n" +
                        "    \"idSymbolCoin\": \"BIT\",\n" +
                        "    \"nameCoin\": \"Bitcoin\",\n" +
                        "    \"iconCoin\": \"www.image.com\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412, response.getStatus());

        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("Symbol Coin alredy exist", error.getMessage());
        Assertions.assertEquals("002", error.getCode());
    }

    @Test
    @Sql("/testdata/get_coins.sql")
    public void getAllCoins() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(Routes.COINS_PATH)
                .contentType(MediaType.APPLICATION_JSON);
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    @Sql("/testdata/get_coins.sql")
    public void getCoinInformationAPIExternalHappyPath() throws Exception {
        CoinApiExternalSummary mockedBody = new CoinApiExternalSummary(new CoinAPIExternal("bitcoin", 1, "BTC", "Bitcoin", 19056412.000, 21000000.000, 578381201943.855, 11833701208.211, 30351.002, 2.4318, 29926.389, "https://blockchain.info/"), 12344.654);
        ResponseEntity<CoinApiExternalSummary> entity = new ResponseEntity(mockedBody, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.<Class<CoinApiExternalSummary>>any())).thenReturn(entity);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(Routes.COINS_PATH+Routes.ID_COINS_PATH, "BTC").contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());

        Coin coin = objectMapper.readValue(response.getContentAsString(), Coin.class);
        Assertions.assertEquals("BTC", coin.getIdSymbolCoin());
        Assertions.assertEquals("Bitcoin", coin.getNameCoin());
    }

    @Test
    public void getCoinInformationAPIExternalNotFoundPath() throws Exception {
        ResponseEntity<CoinApiExternalSummary> entity = new ResponseEntity(HttpStatus.NOT_FOUND);
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.<Class<CoinApiExternalSummary>>any())).thenReturn(entity);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(Routes.COINS_PATH+Routes.ID_COINS_PATH, "BTU").contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(404, response.getStatus());

        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("idSymbolCoin not found", error.getMessage());
    }

    @Test
    public void getCoinInformationAPIExternalBadPath() throws Exception {
        CoinApiExternalSummary mockedBody = new CoinApiExternalSummary(new CoinAPIExternal("bitcoin", 1, "BTC", "Bitcoin", 19056412.000, 21000000.000, 578381201943.855, 11833701208.211, 30351.002, 2.4318, 29926.389, "https://blockchain.info/"), 12344.654);
        ResponseEntity<CoinApiExternalSummary> entity = new ResponseEntity(mockedBody, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.<Class<CoinApiExternalSummary>>any())).thenReturn(entity);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(Routes.COINS_PATH+Routes.ID_COINS_PATH, 12).contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(404, response.getStatus());

        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("idSymbolCoin not found", error.getMessage());
    }


}
