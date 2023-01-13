package fr.elplauto.cryptoTracker.services;

import fr.elplauto.cryptoTracker.model.CryptoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BinanceService {

    @GET("ticker/24hr")
    Call<List<CryptoItem>> get24hrTickerPriceChangeStatistics(@Query("symbols") String symbols);
}
