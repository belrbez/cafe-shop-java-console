package ru.testing.cofeeshop.domain.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Basket extends GenericIdContainer {

    private Integer size = 0;

    private BigDecimal totalCost = new BigDecimal(0);

    private Set<BasketItem> itemSet = new HashSet<>();

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Set<BasketItem> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<BasketItem> itemSet) {
        this.itemSet = itemSet;
    }

    public void addItem(BasketItem item) {
        this.itemSet.add(item);
        this.size++;
        reprocessTotalCost();
    }

    public void removeItem(BasketItem item) {
        this.itemSet.remove(item);
        this.size--;
        reprocessTotalCost();
    }

    public void reprocessTotalCost() {
        totalCost = new BigDecimal(0);
        for (BasketItem basketItem : itemSet) {
            totalCost = totalCost.add(basketItem.getProduct().getPrice().getValue().multiply(new BigDecimal(basketItem.getAmount())));
        }
    }
}
