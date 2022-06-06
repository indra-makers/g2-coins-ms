package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.RestApiClient.Model.CoinApiExterna;
import com.co.indra.coinmarketcap.coins.RestApiClient.Model.Data;
import com.co.indra.coinmarketcap.coins.RestApiClient.Model.ListResponseBody;
import com.co.indra.coinmarketcap.coins.RestApiClient.RestService;
import com.co.indra.coinmarketcap.coins.apiExterna.models.CoinApi;
import com.co.indra.coinmarketcap.coins.apiExterna.service.CoinApiService;
import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private RestService restService;

    @Autowired
    private CoinApiService coinApiService;


    public void registerCoin(String idSymbolCoin, String nameCoin, String iconCoin) {
        if(!coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()) {
            throw new BusinessException(ErrorCodes.ID_SYMBOLCOIN_ALREDY_EXIST);
        }
        coinRepository.create(new Coin(idSymbolCoin, nameCoin, iconCoin));
    }

    public List<Coin> listAllCoins() {
        return coinRepository.listAllCoins();
    }

    public Page<Coin> findAllCoinsPaged(Pageable pageable) {
        Page<Coin> coin = coinRepository.findAllCoinsPaged(pageable);
        return coin;
    }

    public Data findCoinBySymbol(String symbol){
        Data data = restService.getCoinWithResponseHandling(symbol);
        return data;
    }

    public ListResponseBody getResponseBody(){
        return restService.getListResponseBodyWithResponseHandling();
    }

    public Coin getCoinBySymbol(String symbol){
        CoinApiExterna coinApiExterna =restService.getCoinWithResponseHandlingBySymbolOfCoin(symbol);
        return new Coin();
    }

//    public Coin getCoinBySymbolofData(String symbol){
//        return new Coin(restService.getCoinWithResponseHandlingBySymbolOfCoin(symbol).getSymbol(), );
//    }

    public Coin getCoinInListOfCoins(String symbol){
        return buscarCoinInData(symbol, restService.getListResponseBodyWithResponseHandling().getData());
    }

/*    public Coin getCoinMap(String symbol){
        Map<String, String> map = new HashMap<>();
        map = restService.getCoinsIdAndSymbolMap();
        Coin coin = restService.getCoinWithResponseHandling(String.valueOf(map.containsKey(symbol)));
        return ;
    }*/

    public Coin buscarCoinInData(String symbol, List<CoinApiExterna> coinApiExternaList) {
        CoinApiExterna con=null;
        for(int i=0; i<coinApiExternaList.size(); i++) {
            con = coinApiExternaList.get(i);
            if(con.getSymbol().equalsIgnoreCase(symbol)) {
                return new Coin(con.getSymbol(), con.getName(), con.getExplorer());
            }
        }
        return null;
    }

    public String pruebaGetCoin(String symbol){
        CoinApi coinApi = coinApiService.obtenerCoin(symbol);

        if(coinApi.getSymbol()=="BTC"){
            return coinApi.getSymbol();
        }else{
            return "Otro Symbol";
        }
    }




}
