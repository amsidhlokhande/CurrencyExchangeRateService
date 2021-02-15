package com.amsidh.mvc.repositories;

import com.amsidh.mvc.entities.ExchangeRate;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExchangeRateRepository  extends JpaRepository<ExchangeRate, Integer> {

    @Query(value="select exchangeRate from ExchangeRate exchangeRate where exchangeRate.currencyFrom= :currencyFrom and exchangeRate.currencyTo= :currencyTo", nativeQuery = false)
    Optional<ExchangeRate> findByCurrencyFromAndCurrencyTo(@Param("currencyFrom") String currencyFrom, @Param("currencyTo") String currencyTo);
}
