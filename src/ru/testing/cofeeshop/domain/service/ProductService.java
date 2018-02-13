package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

/**
 * The interface Product service.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public interface ProductService {

    /**
     * Add product to basket product dto.
     *
     * @param choosedProduct the choosed product
     * @param amount         the amount
     * @return the product dto
     */
    ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount);

    /**
     * Create and add product addon to product product dto.
     *
     * @param baseProductId  the base product id
     * @param checkedProduct the checked product
     * @param amount         the amount
     * @return the product dto
     */
    ProductDTO createAndAddProductAddonToProduct(Long baseProductId, AvailableProduct checkedProduct, Integer amount);

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
