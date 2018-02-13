package ru.testing.cofeeshop.controller;

import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

/**
 * The interface Product controller.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public interface ProductController {

    /**
     * Add product to basket product dto.
     *
     * @param choosedProduct the choosed product
     * @param amount         the amount
     * @return the product dto
     */
    ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount);

    /**
     * Add addon to product product dto.
     *
     * @param baseProductId  the base product id
     * @param checkedProduct the checked product
     * @param amount         the amount
     * @return the product dto
     */
    ProductDTO addAddonToProduct(Long baseProductId, AvailableProduct checkedProduct, Integer amount);

    /**
     * Add option to product product dto.
     *
     * @param optionType    the option type
     * @param choosedAmount the choosed amount
     * @param productId     the product id
     * @return the product dto
     */
    ProductDTO addOptionToProduct(OptionType optionType, Integer choosedAmount, Long productId);
}