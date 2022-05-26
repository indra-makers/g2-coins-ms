package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.model.entities.HistoryCoin;
import com.co.indra.coinmarketcap.coins.model.responses.ErrorResponse;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import com.co.indra.coinmarketcap.coins.repositories.HistoryCoinRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class HistoryCoinControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private HistoryCoinRepository historyCoinRepository;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Sql("/testdata/get_history_coin.sql")
    public void getHistoryCoinByCoinHappyPath() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.HISTORY_COINS+Routes.GET_HISTORY_COIN, "AAA")
                //.get(Routes.HISTORY_COINS+Routes.GET_HISTORY_COIN+Routes.PAGEABLE, "AAA")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        //------------ las verificaciones--------------------
        Assertions.assertEquals(200, response.getStatus());
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        HistoryCoin[] historyCoins = objectMapper.readValue(response.getContentAsString(), HistoryCoin[].class);
        Assertions.assertEquals(1, historyCoins.length);
        JsonNode nodes = objectMapper.readTree(response.getContentAsString());

        HistoryCoin[] data = objectMapper.readValue(nodes.get("content").toString(), HistoryCoin[].class);
        Assertions.assertEquals(2, data.length);

        Assertions.assertEquals(2, nodes.get("pageable").get("pageSize").asInt());
        Assertions.assertEquals(0, nodes.get("pageable").get("pageNumber").asInt());

    }

    @Test
    @Sql("/testdata/get_history_coin.sql")
    public void getHistoryCoinByCoinNotExist() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.HISTORY_COINS+Routes.GET_HISTORY_COIN, "CCC")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412, response.getStatus());
        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("001", error.getCode());

    }

    @Test
    @Sql("/testdata/get_history_coin.sql")
    public void getHistoryCoinByCoinNotHistoryYet() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.HISTORY_COINS+Routes.GET_HISTORY_COIN, "BBB")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412, response.getStatus());
        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("004", error.getCode());
    }
}
