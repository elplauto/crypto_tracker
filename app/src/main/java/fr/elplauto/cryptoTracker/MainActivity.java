package fr.elplauto.cryptoTracker;

import android.app.Activity;
import android.os.Bundle;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import fr.elplauto.cryptoTracker.databinding.ActivityMainBinding;
import fr.elplauto.cryptoTracker.model.CryptoItem;
import fr.elplauto.cryptoTracker.model.CryptoItemAdapter;
import fr.elplauto.cryptoTracker.services.BinanceService;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;
    private WearableRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mRecyclerView = binding.recyclerLauncherView;
        mRecyclerView.setEdgeItemsCenteringEnabled(true);
        mRecyclerView.setLayoutManager(new WearableLinearLayoutManager(this));

        this.get24hrTickerPriceChangeStatistics();
    }

    private void get24hrTickerPriceChangeStatistics() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.binance.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        List<String> symbols = Arrays.asList("BTCUSDT", "ETHUSDT", "BNBUSDT");
        String symbolsParam = this.getSymbolsParamFormatted(symbols);

        BinanceService service = retrofit.create(BinanceService.class);
        service.get24hrTickerPriceChangeStatistics(symbolsParam).enqueue(new Callback<List<CryptoItem>>() {
            @Override
            public void onResponse(Call<List<CryptoItem>> call, Response<List<CryptoItem>> response) {
                if (response.isSuccessful()) {
                    List<CryptoItem> stockDataList = response.body();
                    StringBuilder sb = new StringBuilder();
                    for (CryptoItem stockData : stockDataList) {
                        sb.append(stockData.getSymbol()).append(" - ").append(stockData.getPriceChangePercent()).append("%");
                        sb.append(" - ").append(stockData.getLastPrice()).append("$");
                    }
                    MainActivity.this.setAdapter(stockDataList);
                }
            }

            @Override
            public void onFailure(Call<List<CryptoItem>> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
    }

    private String getSymbolsParamFormatted(List<String> symbols) {
        StringBuilder symbolsBuilder = new StringBuilder();
        symbolsBuilder.append("[");
        for (String symbol : symbols) {
            symbolsBuilder.append("\"").append(symbol).append("\"").append(",");
        }
        symbolsBuilder.deleteCharAt(symbolsBuilder.length() - 1);
        symbolsBuilder.append("]");
        return symbolsBuilder.toString();
    }

    private void setAdapter(List<CryptoItem> cryptoItems) {
        mRecyclerView.setAdapter(new CryptoItemAdapter(this, cryptoItems, itemPosition -> {
            System.out.println("Item position: " + itemPosition);
        }));
    }
}