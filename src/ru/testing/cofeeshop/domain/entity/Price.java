package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.PriceStrategy;

import java.math.BigDecimal;

/**
 * The type Price.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Price extends GenericIdContainer {

    /**
     * The Value.
     */
    BigDecimal value;

    /**
     * The Price strategy.
     */
    PriceStrategy priceStrategy;

    /**
     * Gets value.
     *
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets price strategy.
     *
     * @return the price strategy
     */
    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    /**
     * Sets price strategy.
     *
     * @param priceStrategy the price strategy
     */
    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }
}
