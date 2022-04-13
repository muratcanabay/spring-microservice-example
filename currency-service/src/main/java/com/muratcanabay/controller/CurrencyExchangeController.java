package com.muratcanabay.controller;

import com.muratcanabay.model.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchange convert(@PathVariable String from, @PathVariable String to) {
        return CurrencyExchange.builder()
                .id(1L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(10))
                .port(environment.getProperty("local.server.port"))
                .build();
    }
}
