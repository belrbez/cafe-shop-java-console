package ru.testing.cofeeshop.controller.model;

import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {

    BigDecimal totalCost;
    private Long id;
    private String name;
    private AvailableProduct availableProduct;
    private CategoryDTO category;
    private List<OptionDTO> optionList;
    private List<ProductDTO> addOns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AvailableProduct getAvailableProduct() {
        return availableProduct;
    }

    public void setAvailableProduct(AvailableProduct availableProduct) {
        this.availableProduct = availableProduct;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<OptionDTO> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionDTO> optionList) {
        this.optionList = optionList;
    }

    public List<ProductDTO> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<ProductDTO> addOns) {
        this.addOns = addOns;
    }
}
