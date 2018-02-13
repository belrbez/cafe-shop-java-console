package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.PaymentType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

/**
 * The type Order.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Order extends GenericIdContainer {

    private Set<BasketItem> boughtProductsSnapshotList;

    private BigDecimal totalCost;

    private OffsetDateTime createdAt;

    private PaymentType paymentType;

    /**
     * Gets products snapshot list.
     *
     * @return the products snapshot list
     */
    public Set<BasketItem> getProductsSnapshotList() {
        return boughtProductsSnapshotList;
    }

    /**
     * Sets products snapshot list.
     *
     * @param boughtProductsSnapshotList the bought products snapshot list
     */
    public void setProductsSnapshotList(Set<BasketItem> boughtProductsSnapshotList) {
        this.boughtProductsSnapshotList = boughtProductsSnapshotList;
    }

    /**
     * Gets total cost.
     *
     * @return the total cost
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets total cost.
     *
     * @param totalCost the total cost
     */
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets payment type.
     *
     * @return the payment type
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Sets payment type.
     *
     * @param paymentType the payment type
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
