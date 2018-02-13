package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.ProductType;

import java.io.Serializable;
import java.util.List;

/**
 * The type Product.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Product extends GenericBillingEntity<ProductType> implements Serializable {

    private Category category;

    private List<Option> optionList;

    private List<Product> addOns;

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets option list.
     *
     * @return the option list
     */
    public List<Option> getOptionList() {
        return optionList;
    }

    /**
     * Sets option list.
     *
     * @param optionList the option list
     */
    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    /**
     * Gets add ons.
     *
     * @return the add ons
     */
    public List<Product> getAddOns() {
        return addOns;
    }

    /**
     * Sets add ons.
     *
     * @param addOns the add ons
     */
    public void setAddOns(List<Product> addOns) {
        this.addOns = addOns;
    }
}
