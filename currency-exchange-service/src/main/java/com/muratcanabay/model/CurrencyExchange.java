package com.muratcanabay.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

    @Id
    private Long id;

    @Column(name = "_from")
    private String from;

    @Column(name = "_to")
    private String to;

    private BigDecimal conversionMultiple;

    private String port;
}

