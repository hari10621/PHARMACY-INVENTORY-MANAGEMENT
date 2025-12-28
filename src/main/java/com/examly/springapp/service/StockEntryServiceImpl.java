package com.examly.springapp.service;

import com.examly.springapp.model.StockEntry;
import com.examly.springapp.repository.StockEntryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEntryServiceImpl implements StockEntryService {

    private final StockEntryRepo stockEntryRepo;

    public StockEntryServiceImpl(StockEntryRepo stockEntryRepo) {
        this.stockEntryRepo = stockEntryRepo;
    }

    @Override
    public StockEntry addStockEntry(StockEntry entry) {
        return stockEntryRepo.save(entry);
    }

    @Override
    public List<StockEntry> getAllStockEntries() {
        return stockEntryRepo.findAll();
    }

    @Override
    public StockEntry getStockEntryById(Long id) {
        return stockEntryRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteStockEntry(Long id) {
        stockEntryRepo.deleteById(id);
    }
}
