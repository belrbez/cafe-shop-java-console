package ru.testing.cofeeshop.controller.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.controller.ProductController;
import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.service.ProductService;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

/**
 * The type Product controller.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class ProductControllerImpl extends GenericController implements ProductController {

    @Override
    public ProductDTO addProductToBasket(AvailableProduct choosedProduct, Integer amount) {
        return ((ProductService) ApplicationContext.getGenericServiceMap().get(ApplicationInstanceType.PRODUCT)).addProductToBasket(choosedProduct, amount);
    }

    @Override
    public ProductDTO addAddonToProduct(Long baseProductId, AvailableProduct checkedProduct, Integer amount) {
        return ((ProductService) ApplicationContext.getGenericServiceMap().get(ApplicationInstanceType.PRODUCT)).createAndAddProductAddonToProduct(baseProductId, checkedProduct, amount);
    }

    @Override
    public ProductDTO addOptionToProduct(OptionType optionType, Integer choosedAmount, Long productId) {
        return ((ProductService) ApplicationContext.getGenericServiceMap().get(ApplicationInstanceType.PRODUCT)).addOptionToProduct(optionType, choosedAmount, productId);
    }
}
