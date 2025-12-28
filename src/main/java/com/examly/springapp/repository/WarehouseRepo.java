package com.examly.springapp.repository;

import com.examly.springapp.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {

    List<Warehouse> findByLocation(String location);

    List<Warehouse> findByLocationAndName(String location, String name);
}
