package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.OptionType;

import java.math.BigDecimal;

public class Option extends GenericBillingEntity<OptionType> {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
