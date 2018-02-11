package ru.testing.cofeeshop.controller.model;

import ru.testing.cofeeshop.domain.value.OptionType;

import java.math.BigDecimal;

public class OptionDTO {

    private String name;

    private OptionType type;

    private BigDecimal price;

    private BigDecimal value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OptionType getType() {
        return type;
    }

    public void setType(OptionType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
