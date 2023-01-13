package fr.elplauto.cryptoTracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoItem {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("priceChange")
    @Expose
    private Double priceChange;
    @SerializedName("priceChangePercent")
    @Expose
    private Double priceChangePercent;
    @SerializedName("weightedAvgPrice")
    @Expose
    private Double weightedAvgPrice;
    @SerializedName("prevClosePrice")
    @Expose
    private Double prevClosePrice;
    @SerializedName("lastPrice")
    @Expose
    private Double lastPrice;
    @SerializedName("lastQty")
    @Expose
    private Double lastQty;
    @SerializedName("bidPrice")
    @Expose
    private Double bidPrice;
    @SerializedName("bidQty")
    @Expose
    private Double bidQty;
    @SerializedName("askPrice")
    @Expose
    private Double askPrice;
    @SerializedName("askQty")
    @Expose
    private Double askQty;
    @SerializedName("openPrice")
    @Expose
    private Double openPrice;
    @SerializedName("highPrice")
    @Expose
    private Double highPrice;
    @SerializedName("lowPrice")
    @Expose
    private Double lowPrice;
    @SerializedName("volume")
    @Expose
    private Double volume;
    @SerializedName("quoteVolume")
    @Expose
    private Double quoteVolume;
    @SerializedName("openTime")
    @Expose
    private Long openTime;
    @SerializedName("closeTime")
    @Expose
    private Long closeTime;
    @SerializedName("firstId")
    @Expose
    private Long firstId;
    @SerializedName("lastId")
    @Expose
    private Long lastId;
    @SerializedName("count")
    @Expose
    private Long count;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Double priceChange) {
        this.priceChange = priceChange;
    }

    public Double getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(Double priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public Double getWeightedAvgPrice() {
        return weightedAvgPrice;
    }

    public void setWeightedAvgPrice(Double weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
    }

    public Double getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(Double prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getLastQty() {
        return lastQty;
    }

    public void setLastQty(Double lastQty) {
        this.lastQty = lastQty;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getBidQty() {
        return bidQty;
    }

    public void setBidQty(Double bidQty) {
        this.bidQty = bidQty;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public Double getAskQty() {
        return askQty;
    }

    public void setAskQty(Double askQty) {
        this.askQty = askQty;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(Double quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
