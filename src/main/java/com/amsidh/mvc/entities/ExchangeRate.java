package com.amsidh.mvc.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class ExchangeRate implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionMultiple;
    private String exchangeEnvironmentInfo;

    public ExchangeRate(Integer id, String currencyFrom, String currencyTo, BigDecimal conversionMultiple) {
        this.id = id;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.conversionMultiple = conversionMultiple;
    }
}
