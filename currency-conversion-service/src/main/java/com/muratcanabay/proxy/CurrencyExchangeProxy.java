package com.muratcanabay.proxy;

import com.muratcanabay.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * If url is not specified then load balancing works and traffic is balanced between instances (2000 and 2001).
 */
//@FeignClient(name = "currency-exchange-service", url = "http://localhost:2000")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to);

}
