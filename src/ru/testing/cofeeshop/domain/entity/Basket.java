package ru.testing.cofeeshop.domain.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * The type Basket.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Basket extends GenericIdContainer {

    private Integer size = 0;

    private BigDecimal totalCost = new BigDecimal(0);

    private Set<BasketItem> itemSet = new HashSet<>();

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
    public Set<BasketItem> getItemSet() {
        return itemSet;
    }

    /**
     * Sets item set.
     *
     * @param itemSet the item set
     */
    public void setItemSet(Set<BasketItem> itemSet) {
        this.itemSet = itemSet;
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(BasketItem item) {
        this.itemSet.add(item);
        this.size++;
        reprocessTotalCost();
    }

    /**
     * Remove item.
     *
     * @param item the item
     */
    public void removeItem(BasketItem item) {
        this.itemSet.remove(item);
        this.size--;
        reprocessTotalCost();
    }

    /**
     * Reprocess total cost.
     */
    public void reprocessTotalCost() {
        totalCost = new BigDecimal(0);
        for (BasketItem basketItem : itemSet) {
            totalCost = totalCost.add(basketItem.getProduct().getPrice().getValue().multiply(new BigDecimal(basketItem.getAmount())));
        }
    }

    /**
     * Gets product from item by id.
     *
     * @param searchId the search id
     * @return the product from item by id
     */
    public Product getProductFromItemById(Long searchId) {
        Optional<BasketItem> productBasket = this.itemSet.stream().filter(item -> item.getProduct().getId().equals(searchId)).findFirst();
        Optional<Product> product = Optional.empty();
        if (!productBasket.isPresent()) {
            for (BasketItem basketItem : this.itemSet) {
                product = getInChainOfAddons(basketItem.getProduct(), searchId);
                if (product.isPresent()) {
                    break;
                }
            }
        } else {
            product = Optional.of(productBasket.get().getProduct());
        }
        return product.get();
    }

    private Optional<Product> getInChainOfAddons(Product product, Long searchId) {
        if (product.getId().equals(searchId)) {
            return Optional.of(product);
        }
        Optional<Product> productInChain = product.getAddOns().stream().filter(item -> item.getId().equals(searchId)).findFirst();
        if (productInChain.isPresent()) {
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
