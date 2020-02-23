package com.example;


import com.example.pojo.CurrencyRates;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyRatesClient {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/C/USD/2020-02-01/2020-02-23");
        InputStreamReader streamReader = new InputStreamReader(url.openStream());
        new Gson().fromJson(streamReader, CurrencyRates.class);
    }
}