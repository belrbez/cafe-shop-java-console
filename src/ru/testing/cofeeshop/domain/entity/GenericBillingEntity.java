package ru.testing.cofeeshop.domain.entity;

/**
 * The type Generic billing entity.
 *
 * @param <E> the type parameter
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public abstract class GenericBillingEntity<E> extends GenericIdContainer {

    private String name;

    private E type;

    private Price price;

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
    public E getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(E type) {
        this.type = type;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Price price) {
        this.price = price;
    }
}
