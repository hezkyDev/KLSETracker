package com.example.klsetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KlseStockTrackerApplication implements CommandLineRunner {

    @Autowired
    private StockService stockService;

    public static void main(String[] args) {
        SpringApplication.run(KlseStockTrackerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Manually call the method to insert data for testing purposes
//        stockService.fetchAndSaveStockData();
    	stockService.fetchAndSaveRealStockData(); // KLSE Stock Tracker
    }
}