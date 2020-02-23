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
        verifyArgumentsLength(args);

        LocalDate fromDate = getFromDate(args[0]);
        LocalDate toDate = LocalDate.now();

        verifyDate(fromDate, toDate);

        String urlString = String.format("http://api.nbp.pl/api/exchangerates/rates/C/USD/%s/%s", fromDate, toDate);

        URL url = new URL(urlString);
        InputStreamReader streamReader = new InputStreamReader(url.openStream());
        CurrencyRates currencyRates = new Gson().fromJson(streamReader, CurrencyRates.class);
        System.out.println(currencyRates);
    }

    private static void verifyDate(LocalDate fromDate, LocalDate toDate) {
        if (fromDate.compareTo(toDate) > 0) {
            throw new IllegalArgumentException("Początkowa data powinna być wcześniejsza: " + fromDate);
        }
    }

    private static void verifyArgumentsLength(String[] args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Podaj proszę początkową datę w formacie yyyy-MM-dd");
        }
    }

    private static LocalDate getFromDate(String arg) {
        LocalDate fromDate;
        try {
            fromDate = LocalDate.parse(arg);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Podaj proszę początkową datę w formacie yyyy-MM-dd");
        }
        return fromDate;
    }
}