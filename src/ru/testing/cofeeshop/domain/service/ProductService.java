package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

public interface ProductService {

    ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount);

    ProductDTO createAndAddProductAddonToProduct(Long baseProductId, AvailableProduct checkedProduct, Integer amount);

    ProductDTO addOptionToProduct(OptionType optionType, Integer choosedAmount, Long productId);
}
