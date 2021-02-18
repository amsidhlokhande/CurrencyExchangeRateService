package com.amsidh.mvc.controller;

import com.amsidh.mvc.entities.ExchangeRate;
import com.amsidh.mvc.service.ExchangeRateService;
import com.amsidh.mvc.service.InstanceInformationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class ExchangeController {

    private ExchangeRateService exchangeRateService;
    private InstanceInformationService instanceInformationService;

    @GetMapping("/")
    public String imHealthy() {
        return "Currency Exchange Rate Service is up and running";
    }

    @GetMapping("/currency-exchange/{fromCurrency}/{toCurrency}")
    public ExchangeRate getExchangeRate(@PathVariable(name = "fromCurrency", required = true) String fromCurrency, @PathVariable(name = "toCurrency", required = true) String toCurrency) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        log.info("Retrieved ExchangeRate fromCurrency {} toCurrency {} value {}", fromCurrency, toCurrency, exchangeRate);
        exchangeRate.setExchangeEnvironmentInfo(instanceInformationService.retrieveInstanceInfo());
        return exchangeRate;
    }
}
