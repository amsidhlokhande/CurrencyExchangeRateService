package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entities.ExchangeRate;
import com.amsidh.mvc.repositories.ExchangeRateRepository;
import com.amsidh.mvc.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeRate getExchangeRate(String fromCurrency, String toCurrency) {
        log.info("Getting fromCurrency {} toCurrency {}", fromCurrency, toCurrency);
        return exchangeRateRepository.findByCurrencyFromAndCurrencyTo(fromCurrency, toCurrency).orElseThrow(() -> new RuntimeException("Unable to find data to convert " + fromCurrency + " to " + toCurrency));
    }
}
