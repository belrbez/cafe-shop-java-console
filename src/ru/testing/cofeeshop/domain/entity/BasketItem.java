package ru.testing.cofeeshop.domain.entity;

import java.io.Serializable;

/**
 * The type Basket item.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class BasketItem extends GenericIdContainer implements Serializable {

    private Product product;

    private Integer amount = 0;

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
