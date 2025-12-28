package com.examly.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.StockMovement;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementController {

    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
