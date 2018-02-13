package ru.testing.cofeeshop.controller.model;

/**
 * The type Basket item dto.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class BasketItemDTO {

    private ProductDTO productDTO;

    private Integer amount = 0;

    /**
     * Gets product dto.
     *
     * @return the product dto
     */
    public ProductDTO getProductDTO() {
        return productDTO;
    }

    /**
     * Sets product dto.
     *
     * @param productDTO the product dto
     */
    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
