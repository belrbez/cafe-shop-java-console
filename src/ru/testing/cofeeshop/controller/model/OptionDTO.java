package ru.testing.cofeeshop.controller.model;

import ru.testing.cofeeshop.domain.value.OptionType;

import java.math.BigDecimal;

/**
 * The type Option dto.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class OptionDTO {

    private String name;

    private OptionType type;

    private BigDecimal price;

    private BigDecimal value;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public OptionType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(OptionType type) {
        this.type = type;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

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
