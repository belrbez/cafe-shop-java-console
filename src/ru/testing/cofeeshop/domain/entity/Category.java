package ru.testing.cofeeshop.domain.entity;

import ru.testing.cofeeshop.domain.value.ProductCategory;

import java.util.List;

/**
 * The type Category.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Category extends GenericBillingEntity<ProductCategory> {

    private List<Category> childrenCategoryList;

    private List<Option> optionList;

    /**
     * Gets children category list.
     *
     * @return the children category list
     */
    public List<Category> getChildrenCategoryList() {
        return childrenCategoryList;
    }

    /**
     * Sets children category list.
     *
     * @param childrenCategoryList the children category list
     */
    public void setChildrenCategoryList(List<Category> childrenCategoryList) {
        this.childrenCategoryList = childrenCategoryList;
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
}
