package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.OptionType;

import java.math.BigDecimal;

/**
 * The type Option.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Option extends GenericBillingEntity<OptionType> {

    private BigDecimal value;

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
}
