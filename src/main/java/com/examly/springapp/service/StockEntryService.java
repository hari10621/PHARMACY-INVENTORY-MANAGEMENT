package com.examly.springapp.service;

import com.examly.springapp.model.StockEntry;

import java.util.List;

public interface StockEntryService {

    StockEntry addStockEntry(StockEntry entry);

    List<StockEntry> getAllStockEntries();

    StockEntry getStockEntryById(Long id);

    void deleteStockEntry(Long id);
}
