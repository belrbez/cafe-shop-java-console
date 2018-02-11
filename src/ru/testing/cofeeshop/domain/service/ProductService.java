package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

public interface ProductService {

    ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount);
}
