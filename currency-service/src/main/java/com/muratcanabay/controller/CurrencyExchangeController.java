package com.muratcanabay.controller;

import com.muratcanabay.model.CurrencyExchange;
import com.muratcanabay.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchange convert(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.getByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find currency");
        }
        currencyExchange.setPort(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
