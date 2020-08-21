package com.example.demo.feignClient;

import com.example.demo.model.UnitForExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "${external-api.exchange.name}", url = "${external-api.exchange.url}")
public interface UnitForExchangeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/latest?base={base}&symbols={symbols}")
    UnitForExchange convertCurrency(@RequestParam(value="base") String base, @RequestParam(value="symbols") String symbols);

    @RequestMapping(method = RequestMethod.GET, value = "/{date}?base={base}&symbols={symbols}")
    UnitForExchange convertCurrencyByGivenDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(value="base") String base, @RequestParam(value="symbols") String symbols);
}
