package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.ErrorResponse;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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


}
