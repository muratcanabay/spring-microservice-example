package com.muratcanabay.repository;

import com.muratcanabay.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange getByFromAndTo(String from, String to);
}
