package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.ProductType;

import java.io.Serializable;
import java.util.List;

public class Product extends GenericBillingEntity<ProductType> implements Serializable {

    private Category category;

    private List<Option> optionList;

    private List<Product> addOns;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public List<Product> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<Product> addOns) {
        this.addOns = addOns;
    }
}
