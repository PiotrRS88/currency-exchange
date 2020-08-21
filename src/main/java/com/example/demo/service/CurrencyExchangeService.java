package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CurrencyExchangeService {
    BigDecimal convertFromTo(String base, String symbols, BigDecimal value);
    BigDecimal convertFromToByGivenDate(LocalDate date, String base, String symbols, BigDecimal value );
}
