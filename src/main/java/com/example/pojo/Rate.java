package com.example.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rate {

    @SerializedName("no")
    @Expose
    private String no;

    @SerializedName("effectiveDate")
    @Expose
    private String effectiveDate;

    @SerializedName("bid")
    @Expose
    private Double sellPrice;

    @SerializedName("ask")
    @Expose
    private Double buyPrice;

    @Override
    public String toString() {
        return "Data: " + effectiveDate +
                "\n\tcena kupna: " + buyPrice +
                "\n\tcena sprzedaży: " + sellPrice +
                "\n\tróżnica: " + (buyPrice - sellPrice);
    }
}