package ru.testing.cofeeshop.controller.model;

public class BasketItemDTO {

    private ProductDTO productDTO;

    private Integer amount = 0;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
