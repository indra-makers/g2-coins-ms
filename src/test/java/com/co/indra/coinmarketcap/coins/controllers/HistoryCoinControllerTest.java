package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import com.co.indra.coinmarketcap.coins.repositories.HistoryCoinRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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
    public void getHistoryCoinByCoinHappyPath() throws Exception{

    }

    @Test
    public void getHistoryCoinByCoinNotExist() throws Exception{

    }

    @Test
    public void getHistoryCoinByCoinNotHistoryYet() throws Exception{

    }
}
