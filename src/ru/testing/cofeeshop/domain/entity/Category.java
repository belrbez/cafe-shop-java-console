package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.ProductCategory;

import java.util.List;

public class Category extends GenericBillingEntity<ProductCategory> {

    private List<Category> childrenCategoryList;

    private List<Option> optionList;

    public List<Category> getChildrenCategoryList() {
        return childrenCategoryList;
    }

    public void setChildrenCategoryList(List<Category> childrenCategoryList) {
        this.childrenCategoryList = childrenCategoryList;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
