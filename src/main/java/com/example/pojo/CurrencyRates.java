package com.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRates {

    @SerializedName("table")
    @Expose
    private String table;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("rates")
    @Expose
    private List<Rate> rates = null;

    private List<Rate> getRates() {
        return rates == null ? Collections.emptyList() : Collections.unmodifiableList(rates);
    }

    @Override
    public String toString() {
        return getRates().stream()
                .map(Rate::toString)
                .collect(Collectors.joining("\n"));
    }
}