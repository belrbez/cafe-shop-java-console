package ru.testing.cofeeshop.domain.service.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.controller.mapper.ProductMapper;
import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.entity.BasketItem;
import ru.testing.cofeeshop.domain.entity.Product;
import ru.testing.cofeeshop.domain.service.ProductService;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

public class ProductServiceImpl extends GenericService implements ProductService {

    @Override
    public ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount) {
        Product product = (Product) ApplicationContext.getGenericFactoryMap().get(ApplicationInstanceType.PRODUCT).get(choosedProduct);

        BasketItem basketItem = new BasketItem();
        basketItem.setProduct(product);
        basketItem.setAmount(amount);
        ApplicationContext.getUserDetails().getBasket().addItem(basketItem);

        ProductDTO productDTO = ProductMapper.mapProductIntoDTO(product, choosedProduct);
        return productDTO;
    }

}