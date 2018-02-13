package ru.testing.cofeeshop.controller.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Basket dto.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class BasketDTO {

    private Integer size = 0;

    private BigDecimal totalCost = new BigDecimal(0);

    private Set<BasketItemDTO> itemSet = new HashSet<>();

    /**
     * Gets size.
     *
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(Integer size) {
        this.size = size;
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
     * Gets item set.
     *
     * @return the item set
     */
    public Set<BasketItemDTO> getItemSet() {
        return itemSet;
    }

    /**
     * Sets item set.
     *
     * @param itemSet the item set
     */
    public void setItemSet(Set<BasketItemDTO> itemSet) {
        this.itemSet = itemSet;
    }
}
