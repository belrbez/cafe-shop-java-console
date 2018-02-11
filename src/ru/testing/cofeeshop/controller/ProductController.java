package ru.testing.cofeeshop.controller;

import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

public interface ProductController {

    ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount);
}
