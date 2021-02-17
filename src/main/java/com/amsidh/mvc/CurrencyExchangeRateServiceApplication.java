package com.amsidh.mvc;

import com.amsidh.mvc.entities.ExchangeRate;
import com.amsidh.mvc.repositories.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class CurrencyExchangeRateServiceApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeRateServiceApplication.class, args);
    }

    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public void run(String... args) {
        if (exchangeRateRepository.findAll().isEmpty()) {
            log.info("Initializing Database");
            exchangeRateRepository.saveAll(loadInitialData());
        }
    }

    private List<ExchangeRate> loadInitialData() {
        return Arrays.asList(
                new ExchangeRate(10001, "USD", "INR", new BigDecimal(65)),
                new ExchangeRate(10002, "EUR", "INR", new BigDecimal(75)),
                new ExchangeRate(10003, "AUD", "INR", new BigDecimal(25)),

                new ExchangeRate(10004, "INR", "USD", new BigDecimal(1).divide(new BigDecimal(65),4, RoundingMode.HALF_UP)),
                new ExchangeRate(10005, "INR", "EUR", new BigDecimal(1).divide(new BigDecimal(75),4, RoundingMode.HALF_UP)),
                new ExchangeRate(10006, "INR", "AUD", new BigDecimal(1).divide(new BigDecimal(25),4, RoundingMode.HALF_UP))
        );
    }


}
