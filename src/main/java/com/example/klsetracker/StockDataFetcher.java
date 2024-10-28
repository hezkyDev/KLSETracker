package com.example.klsetracker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class StockDataFetcher {

    private static final String KLSE_URL = "https://klse.i3investor.com/index.jsp";

    public StockData fetchStockData() {
        StockData stockData = new StockData();

        try {
            Document document = Jsoup.connect(KLSE_URL).get();

            // Fetch elements for gainers and losers
            Element gainers = document.getElementById("tab-gainers");
            Element losers = document.getElementById("tab-losers");

            // Count the stock entries for gainers and losers
            if (gainers != null) {
                System.out.println("Gainers Element: " + gainers.text());
                stockData.setNumGainers(countStockEntries(gainers.text()));
            } else {
                System.out.println("Gainers Element not found.");
            }

            if (losers != null) {
                System.out.println("Losers Element: " + losers.text());
                stockData.setNumLosers(countStockEntries(losers.text()));
            } else {
                System.out.println("Losers Element not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockData;
    }

    private int countStockEntries(String text) {
        // Split the text into lines, assuming each line or block represents a stock entry
        String[] lines = text.split("(?<=\\d{1,3},\\d{3})");

        // Filter lines that resemble a stock entry format and count them
        int count = 0;
        for (String line : lines) {
            if (line.matches(".*\\d+\\.\\d+ [+-]\\d+\\.\\d+ \\d{1,3},\\d{3}.*")) {
                count++;
            }
        }
        return count;
    }
}