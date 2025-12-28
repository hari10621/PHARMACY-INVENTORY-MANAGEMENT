package com.examly.springapp.controller;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse created = warehouseService.addWarehouse(warehouse);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> list = warehouseService.getAllWarehouses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id,
                                                     @RequestBody Warehouse warehouse) {
        Warehouse updated = warehouseService.updateWarehouse(id, warehouse);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }

    // Day 11: by location
    @GetMapping("/location/{location}")
    public ResponseEntity<?> getWarehousesByLocation(@PathVariable String location) {
        List<Warehouse> list = warehouseService.getWarehousesByLocation(location);
        if (list.isEmpty()) {
            String message = "No warehouses found at location: " + location;
            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Day 12: by location and name
    @GetMapping("/location/{location}/name/{name}")
    public ResponseEntity<List<Warehouse>> getWarehouseByLocationAndName(@PathVariable String location,
                                                                         @PathVariable String name) {
        List<Warehouse> list = warehouseService.getWarehousesByLocationAndName(location, name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
