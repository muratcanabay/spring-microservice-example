package com.muratcanabay.controller;

import com.muratcanabay.model.CurrencyConversion;
import com.muratcanabay.proxy.CurrencyExchangeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyExchange = currencyExchangeProxy.getCurrencyExchange(from, to);

        return CurrencyConversion.builder()
                .id(currencyExchange.getId())
                .from(from)
                .to(to)
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .quantity(quantity)
                .totalCalculatedAmount(quantity.multiply(currencyExchange.getConversionMultiple()))
                .port(currencyExchange.getPort())
                .build();
    }
}
