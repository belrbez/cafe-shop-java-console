package ru.testing.cofeeshop.controller.model;

import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Product dto.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class ProductDTO {

    /**
     * The Total cost.
     */
    BigDecimal totalCost;
    private Long id;
    private String name;
    private AvailableProduct availableProduct;
    private CategoryDTO category;
    private List<OptionDTO> optionList;
    private List<ProductDTO> addOns;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets available product.
     *
     * @return the available product
     */
    public AvailableProduct getAvailableProduct() {
        return availableProduct;
    }

    /**
     * Sets available product.
     *
     * @param availableProduct the available product
     */
    public void setAvailableProduct(AvailableProduct availableProduct) {
        this.availableProduct = availableProduct;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public CategoryDTO getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(CategoryDTO category) {
        this.category = category;
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

    /**
     * Gets add ons.
     *
     * @return the add ons
     */
    public List<ProductDTO> getAddOns() {
        return addOns;
    }

    /**
     * Sets add ons.
     *
     * @param addOns the add ons
     */
    public void setAddOns(List<ProductDTO> addOns) {
        this.addOns = addOns;
    }
}
