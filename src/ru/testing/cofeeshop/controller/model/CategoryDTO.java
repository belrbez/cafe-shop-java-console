package ru.testing.cofeeshop.controller.model;

import ru.testing.cofeeshop.domain.value.ProductCategory;

import java.util.List;

public class CategoryDTO {

    private ProductCategory type;

    private List<CategoryDTO> childrenCategoryList;

    private List<OptionDTO> optionList;

    public ProductCategory getType() {
        return type;
    }

    public void setType(ProductCategory type) {
        this.type = type;
    }

    public List<CategoryDTO> getChildrenCategoryList() {
        return childrenCategoryList;
    }

    public void setChildrenCategoryList(List<CategoryDTO> childrenCategoryList) {
        this.childrenCategoryList = childrenCategoryList;
    }

    public List<OptionDTO> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionDTO> optionList) {
        this.optionList = optionList;
    }
}
