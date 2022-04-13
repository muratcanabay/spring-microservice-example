package com.muratcanabay.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CurrencyExchange {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String port;
}
