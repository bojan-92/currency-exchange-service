package com.udemy.microservices.currencyexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_from", nullable = false)
    private String from;

    @Column(name = "currency_to", nullable = false)
    private String to;

    @Column(name = "conversation_multiple", nullable = false)
    private BigDecimal conversionMultiple;

    private String environment;

    public CurrencyExchange() {
    }

}
