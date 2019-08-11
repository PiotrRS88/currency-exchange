package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class UnitForExchange {
    private BigDecimal amount;
    private String haveCurrency;
    private String wantCurrency;

}

