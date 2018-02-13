package ru.testing.cofeeshop.controller.model;

import ru.testing.cofeeshop.domain.value.ProductCategory;

import java.util.List;

/**
 * The type Category dto.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class CategoryDTO {

    private ProductCategory type;

    private List<CategoryDTO> childrenCategoryList;

    private List<OptionDTO> optionList;

    /**
     * Gets type.
     *
     * @return the type
     */
    public ProductCategory getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(ProductCategory type) {
        this.type = type;
    }

    /**
     * Gets children category list.
     *
     * @return the children category list
     */
    public List<CategoryDTO> getChildrenCategoryList() {
        return childrenCategoryList;
    }

    /**
     * Sets children category list.
     *
     * @param childrenCategoryList the children category list
     */
    public void setChildrenCategoryList(List<CategoryDTO> childrenCategoryList) {
        this.childrenCategoryList = childrenCategoryList;
    }

    /**
     * Gets option list.
     *
     * @return the option list
     */
    public List<OptionDTO> getOptionList() {
        return optionList;
    }

    /**
     * Sets option list.
     *
     * @param optionList the option list
     */
    public void setOptionList(List<OptionDTO> optionList) {
        this.optionList = optionList;
    }
}
