package com.example.klsetracker;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StockServiceTest {

    @InjectMocks
    private StockService stockService;

    @Mock
    private StockSummaryRepository stockSummaryRepository;

    @Mock
    private StockDataFetcher stockDataFetcher;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAndSaveRealStockData() {
        // Create mock data to simulate real data fetching
        StockData mockData = new StockData();
        mockData.setNumGainers(10);
        mockData.setNumLosers(5);

        // Configure stockDataFetcher to return the mock data
        when(stockDataFetcher.fetchStockData()).thenReturn(mockData);

        // Call the method to be tested
        stockService.fetchAndSaveRealStockData();

        // Verify that stockSummaryRepository.save() was called once
        verify(stockSummaryRepository, times(1)).save(any(StockSummary.class));
    }
}