package com.example.klsetracker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Service
public class StockService {

    @Autowired
    private StockSummaryRepository stockSummaryRepository;

    @Autowired
    private StockDataFetcher stockDataFetcher;

    // mock data
//    @Scheduled(cron = "0 0 0 * * ?")
//    public void fetchAndSaveStockData() {
//        int numGainers = 50;  // Mock data
//        int numLosers = 30;   // Mock data
//
//        StockSummary summary = new StockSummary();
//        summary.setRecordDateTime(LocalDateTime.now());
//        summary.setNumGainers(numGainers);
//        summary.setNumLosers(numLosers);
//
//        stockSummaryRepository.save(summary);
//    }

    // real stock data
    @Scheduled(cron = "0 0 12 * * ?") // Example: Runs at noon every day
    public void fetchAndSaveRealStockData() {
        // Fetch real stock data using StockDataFetcher
        StockData stockData = stockDataFetcher.fetchStockData();

        StockSummary summary = new StockSummary();
        summary.setRecordDateTime(LocalDateTime.now());
        summary.setNumGainers(stockData.getNumGainers());
        summary.setNumLosers(stockData.getNumLosers());

        stockSummaryRepository.save(summary);
    }
}