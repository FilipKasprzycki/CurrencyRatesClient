package com.example;


import com.example.pojo.CurrencyRates;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;


public class CurrencyRatesClient {
    public static void main(String[] args) throws IOException {
        LocalDate fromDate = LocalDate.parse("2020-02-01");
        LocalDate toDate = LocalDate.parse("2020-02-23");

        String urlString = String.format("http://api.nbp.pl/api/exchangerates/rates/C/USD/%s/%s", fromDate, toDate);

        URL url = new URL(urlString);
        InputStreamReader streamReader = new InputStreamReader(url.openStream());
        CurrencyRates currencyRates = new Gson().fromJson(streamReader, CurrencyRates.class);
        System.out.println(currencyRates);
    }
}