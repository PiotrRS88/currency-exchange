package com.example.demo.controller;

import com.example.demo.model.UnitForExchange;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/exchange")
public class CurrencyExchangeController {

    @PostMapping
    public BigDecimal changeCurrency(@RequestBody UnitForExchange unitForExchange) {
        BigDecimal b1 = new BigDecimal("4");

        BigDecimal result = unitForExchange.getAmount().multiply(b1);

        return result;
    }
    //TODO:
    // klasa Service- kontakt z NBP
    // Feign- jak korzystać z tego poprzez Boota, aby skontaktować się z NBP i wyciągnąć dane z URL
    // Service będzie wstrzyknięty do Controllera
}
