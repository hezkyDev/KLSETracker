package com.example.klsetracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class StockSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime recordDateTime;
    private int numGainers;
    private int numLosers;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(LocalDateTime recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

    public int getNumGainers() {
        return numGainers;
    }

    public void setNumGainers(int numGainers) {
        this.numGainers = numGainers;
    }

    public int getNumLosers() {
        return numLosers;
    }

    public void setNumLosers(int numLosers) {
        this.numLosers = numLosers;
    }
}