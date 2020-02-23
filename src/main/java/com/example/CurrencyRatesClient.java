package com.example;


import com.example.pojo.CurrencyRates;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class CurrencyRatesClient {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Podaj proszę początkową datę w formacie yyyy-MM-dd");
        }

        LocalDate fromDate;
        try {
            fromDate = LocalDate.parse(args[0]);
        } catch(DateTimeParseException e) {
            throw new IllegalArgumentException("Podaj proszę początkową datę w formacie yyyy-MM-dd");
        }
        LocalDate toDate = LocalDate.now();

        if(fromDate.compareTo(toDate) > 0) {
            throw new IllegalArgumentException("Początkowa data powinna być wcześniejsza: " + fromDate);
        }

        String urlString = String.format("http://api.nbp.pl/api/exchangerates/rates/C/USD/%s/%s", fromDate, toDate);

        URL url = new URL(urlString);
        InputStreamReader streamReader = new InputStreamReader(url.openStream());
        CurrencyRates currencyRates = new Gson().fromJson(streamReader, CurrencyRates.class);
        System.out.println(currencyRates);
    }
}