package com.amsidh.mvc.service;

import com.amsidh.mvc.entities.ExchangeRate;

public interface ExchangeRateService {

    ExchangeRate getExchangeRate(String fromCurrency, String toCurrency);
}
