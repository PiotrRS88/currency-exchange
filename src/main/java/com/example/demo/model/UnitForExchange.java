package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UnitForExchange {
    String base;
    String symbols;
    LocalDate date;
    Map<String, BigDecimal> rates;
}

