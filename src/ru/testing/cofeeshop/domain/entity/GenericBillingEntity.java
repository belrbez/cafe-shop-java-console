package ru.testing.cofeeshop.domain.entity;

public abstract class GenericBillingEntity<E> extends GenericIdContainer {

    private String name;

    private E type;

    private Price price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
