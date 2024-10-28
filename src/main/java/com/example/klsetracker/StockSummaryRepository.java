package com.example.klsetracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockSummaryRepository extends JpaRepository<StockSummary, Long> {
}