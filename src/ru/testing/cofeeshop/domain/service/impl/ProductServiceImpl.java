package ru.testing.cofeeshop.domain.service.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.controller.mapper.ProductMapper;
import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.entity.BasketItem;
import ru.testing.cofeeshop.domain.entity.Option;
import ru.testing.cofeeshop.domain.entity.Product;
import ru.testing.cofeeshop.domain.service.ProductService;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Product service.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
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

    @Override
    public ProductDTO createAndAddProductAddonToProduct(Long baseProductId, AvailableProduct choosedProduct, Integer amount) {
        Product baseProduct = ApplicationContext.getUserDetails().getBasket().getProductFromItemById(baseProductId);
        Product productAddon = (Product) ApplicationContext.getGenericFactoryMap().get(ApplicationInstanceType.PRODUCT).get(choosedProduct);
        if (baseProduct.getAddOns() == null) {
            List<Product> newAddons = new ArrayList<>();
            newAddons.add(productAddon);
            baseProduct.setAddOns(newAddons);
        } else {
            baseProduct.getAddOns().add(productAddon);
        }
        //TODO Refactor it into List<BasketItem> in BasketItem.
        for (Integer i = 1; i < amount; i++) {
            Product productAddon1 = (Product) ApplicationContext.getGenericFactoryMap().get(ApplicationInstanceType.PRODUCT).get(choosedProduct);
            baseProduct.getAddOns().add(productAddon1);
        }
        ProductDTO productAddonDTO = ProductMapper.mapProductIntoDTO(productAddon);
        return productAddonDTO;
    }

    @Override
    public ProductDTO addOptionToProduct(OptionType optionType, Integer choosedAmount, Long productId) {
        Product baseProduct = ApplicationContext.getUserDetails().getBasket().getProductFromItemById(productId);

        Option option = (Option) ApplicationContext.getGenericFactoryMap().get(ApplicationInstanceType.OPTION).get(optionType);
        option.setValue(new BigDecimal(choosedAmount));
        baseProduct.setOptionList(Collections.singletonList(option));

        ProductDTO productDTO = ProductMapper.mapProductIntoDTO(baseProduct);
        return productDTO;
    }

}