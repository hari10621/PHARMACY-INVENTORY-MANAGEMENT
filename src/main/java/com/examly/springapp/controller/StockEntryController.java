package com.examly.springapp.controller;

import com.examly.springapp.model.StockEntry;
import com.examly.springapp.service.StockEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockEntries")
public class StockEntryController {

    private final StockEntryService stockEntryService;

    public StockEntryController(StockEntryService stockEntryService) {
        this.stockEntryService = stockEntryService;
    }

    @PostMapping
    public ResponseEntity<StockEntry> addStockEntry(@RequestBody StockEntry entry) {
        StockEntry created = stockEntryService.addStockEntry(entry);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StockEntry>> getAllStockEntries() {
        List<StockEntry> list = stockEntryService.getAllStockEntries();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockEntry> getStockEntryById(@PathVariable Long id) {
        StockEntry entry = stockEntryService.getStockEntryById(id);
        if (entry == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockEntry(@PathVariable Long id) {
        stockEntryService.deleteStockEntry(id);
        return ResponseEntity.noContent().build();
    }
}
