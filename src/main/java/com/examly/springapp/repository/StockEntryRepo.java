package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Repository
public class StockEntryRepo {
    @Id
    private String stock;
}
