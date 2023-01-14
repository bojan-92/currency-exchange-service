package com.udemy.microservices.currencyexchangeservice.controller;

import com.udemy.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.udemy.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/currency-exchange")
@Slf4j
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeRepository repository;
    @Autowired
    private Environment environment;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        log.info("getExchangeValue method called with {} to {}", from, to);
        Optional<CurrencyExchange> currencyExchange = repository.findByFromAndTo(from, to);
        if (currencyExchange.isEmpty()) {
            log.error("Unable to find data for from {} and to {}", from, to);
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.get().setEnvironment(port);

        return currencyExchange.get();
    }
}
