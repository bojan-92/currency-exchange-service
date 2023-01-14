package com.udemy.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sampleApi")
//    @Retry(name = "sampleApi", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "sampleApi", fallbackMethod = "hardcodedResponse")
    //we define time period and specific number of calls in that period
    @RateLimiter(name = "default")
    public String sampleApi() {
        logger.info("Sample Api call received");
//        ResponseEntity<String> response =
//                new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//        return response.getBody();
        return "sampleApi";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback response";
    }
}
