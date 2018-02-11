package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.PaymentType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

public class Order extends GenericIdContainer {

    private Set<BasketItem> boughtProductsSnapshotList;

    private BigDecimal totalCost;

    private OffsetDateTime createdAt;

    private PaymentType paymentType;

    public Set<BasketItem> getProductsSnapshotList() {
        return boughtProductsSnapshotList;
    }

    public void setProductsSnapshotList(Set<BasketItem> boughtProductsSnapshotList) {
        this.boughtProductsSnapshotList = boughtProductsSnapshotList;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
