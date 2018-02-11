package ru.testing.cofeeshop.domain.entity;

import java.io.Serializable;

public class BasketItem extends GenericIdContainer implements Serializable {

    private Product product;

    private Integer amount = 0;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
