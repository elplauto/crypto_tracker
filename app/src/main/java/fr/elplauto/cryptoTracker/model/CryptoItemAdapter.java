package fr.elplauto.cryptoTracker.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.elplauto.cryptoTracker.R;
import fr.elplauto.cryptoTracker.utils.PriceFormatter;

import java.util.List;

public class CryptoItemAdapter extends RecyclerView.Adapter<CryptoItemAdapter.RecyclerViewHolder> {

    private final List<CryptoItem> dataSource;

    public interface AdapterCallback {
        void onItemClicked(Integer menuPosition);
    }

    private final AdapterCallback callback;
    private final Context context;


    public CryptoItemAdapter(Context context, List<CryptoItem> dataSource, AdapterCallback callback) {
        this.context = context;
        this.dataSource = dataSource;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_list_item, parent, false);

        return new RecyclerViewHolder(view);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemContainer;
        TextView itemName;
        TextView itemPrice;
        ImageView itemIcon;
        TextView itemChangePercent;

        public RecyclerViewHolder(View view) {
            super(view);
            itemContainer = view.findViewById(R.id.crypto_item_container);
            itemName = view.findViewById(R.id.crypto_item_name);
            itemIcon = view.findViewById(R.id.crypto_item_icon);
            itemPrice = view.findViewById(R.id.crypto_item_price);
            itemChangePercent = view.findViewById(R.id.crypto_item_change_percent);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        CryptoItem cryptoItem = dataSource.get(holder.getAbsoluteAdapterPosition());

        holder.itemPrice.setText(PriceFormatter.decimalPriceFormat(cryptoItem.getLastPrice()));
        String symbol = cryptoItem.getSymbol().toLowerCase();
        if (cryptoItem.getSymbol().toLowerCase().endsWith("usdt")) {
            symbol = cryptoItem.getSymbol().toLowerCase().replace("usdt", "");
        } else if (cryptoItem.getSymbol().toLowerCase().endsWith("eur")) {
            symbol = cryptoItem.getSymbol().toLowerCase().replace("eur", "");
        }
        holder.itemName.setText(symbol.toUpperCase());
        String priceChangePercent = PriceFormatter.formatPercentage(cryptoItem.getPriceChangePercent());
        if (cryptoItem.getPriceChangePercent() > 0) {
            priceChangePercent = "+" + priceChangePercent;
            holder.itemChangePercent.setBackground(context.getDrawable(R.drawable.green_percentage_change_bg));
        } else {
            holder.itemChangePercent.setBackground(context.getDrawable(R.drawable.red_percentage_change_bg));
        }
        holder.itemChangePercent.setText(priceChangePercent);
        holder.itemIcon.setImageResource(context.getResources().getIdentifier("icon_" + symbol , "drawable", context.getPackageName()));
        holder.itemContainer.setOnClickListener(v -> {
            if (callback != null) {
                callback.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
