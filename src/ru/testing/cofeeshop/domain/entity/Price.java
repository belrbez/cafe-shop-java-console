package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.PriceStrategy;

import java.math.BigDecimal;

public class Price extends GenericIdContainer {

    BigDecimal value;

    PriceStrategy priceStrategy;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }
}
