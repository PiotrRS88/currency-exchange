package com.example.demo.controller;

import com.example.demo.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController

public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/convert")
    public BigDecimal convertCurrency(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("value") BigDecimal value) {
        return currencyExchangeService.convertFromTo(from, to, value);
    }

    @GetMapping("/convert/asd")
    public BigDecimal convertCurrencyByGivenDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("value") BigDecimal value) {
        return currencyExchangeService.convertFromToByGivenDate(date, from, to, value);
    }
}
