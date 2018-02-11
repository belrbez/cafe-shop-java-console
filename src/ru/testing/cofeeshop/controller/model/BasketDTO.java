package ru.testing.cofeeshop.controller.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BasketDTO {

    private Integer size = 0;

    private BigDecimal totalCost = new BigDecimal(0);

    private Set<BasketItemDTO> itemSet = new HashSet<>();

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

    public Set<BasketItemDTO> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<BasketItemDTO> itemSet) {
        this.itemSet = itemSet;
    }
}
