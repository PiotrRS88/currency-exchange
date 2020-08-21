package com.example.demo.service;

import com.example.demo.feignClient.UnitForExchangeClient;
import com.example.demo.model.UnitForExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Autowired
    private UnitForExchangeClient unitForExchangeClient;

    @Override
    public BigDecimal convertFromTo(String from, String to, BigDecimal value) {
        UnitForExchange response = unitForExchangeClient.convertCurrency(from, to);
        BigDecimal rate = response.getRates().get(to);
        return value.multiply(rate);
    }

    @Override
    public BigDecimal convertFromToByGivenDate(LocalDate date, String from, String to, BigDecimal value) {
        UnitForExchange response = unitForExchangeClient.convertCurrencyByGivenDate(date, from, to);
        BigDecimal rate = response.getRates().get(to);
        return value.multiply(rate);
    }
}
