package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.domain.entity.Category;
import ru.testing.cofeeshop.domain.entity.Price;
import ru.testing.cofeeshop.domain.entity.Product;
import ru.testing.cofeeshop.domain.value.PriceStrategy;
import ru.testing.cofeeshop.domain.value.ProductCategory;
import ru.testing.cofeeshop.domain.value.ProductType;
import ru.testing.cofeeshop.productcatalog.IdGenerator;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * The type Product factory.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class ProductFactory extends GenericFactory<Product, AvailableProduct> {

    private static Long numberOfProducts = 0L;

    @Override
    public Product get(AvailableProduct availableProduct) {
        Product product = new Product();
        IdGenerator.generateAndSetId(product, numberOfProducts);
        product.setName(String.format("%s %s", availableProduct.getValue(), product.getId()));
        Category category;
        switch (availableProduct) {
            case GREEN_TEA:
                product.setType(ProductType.BASE);
                category = generateCategory(ProductCategory.TEA, ProductCategory.GREEN_TEA);
                break;
            case WHITE_TEA:
                product.setType(ProductType.BASE);
                category = generateCategory(ProductCategory.TEA, ProductCategory.WHITE_TEA);
                break;
            case BLACK_TEA:
                product.setType(ProductType.BASE);
                category = generateCategory(ProductCategory.TEA, ProductCategory.BLACK_TEA);
                break;
            case LATTE_COFFEE:
                product.setType(ProductType.BASE);
                category = generateCategory(ProductCategory.COFFEE, ProductCategory.LATTE_COFFEE);
                break;
            case BLACK_COFFEE:
                product.setType(ProductType.BASE);
                category = generateCategory(ProductCategory.COFFEE, ProductCategory.BLACK_COFFEE);
                break;
            case ESPRESSO_COFFEE:
                product.setType(ProductType.BASE);
                category = generateCategory(ProductCategory.COFFEE, ProductCategory.ESPRESSO_COFFEE);
                break;
            case MILK_ADD_ON_CREAM:
                product.setType(ProductType.ADD_ON);
                category = generateCategory(ProductCategory.MILK_ADD_ON, ProductCategory.CREAM);
                break;
            case MILK_ADD_ON_MILK:
                product.setType(ProductType.ADD_ON);
                category = generateCategory(ProductCategory.MILK_ADD_ON, ProductCategory.MILK);
                break;
            case SWEET_ADD_ON_SUGAR:
                product.setType(ProductType.ADD_ON);
                category = generateCategory(ProductCategory.MILK_ADD_ON, ProductCategory.CREAM);
                break;
            case SWEET_ADD_ON_HONEY:
                product.setType(ProductType.ADD_ON);
                category = generateCategory(ProductCategory.MILK_ADD_ON, ProductCategory.CREAM);
                break;
            case OTHER_ADD_ON_LEMON:
                product.setType(ProductType.ADD_ON);
                category = generateCategory(ProductCategory.OTHER_ADD_ON, ProductCategory.OTHER_ADD_ON);
                break;
            default:
                throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknown Product to create!");
        }
        product.setCategory(category);
        product.setPrice(generateTotalPriceForProduct(product));
        numberOfProducts++;
        return product;
    }

    private Price generateTotalPriceForProduct(Product product) {
        Price totalPrice = new Price();
        totalPrice.setPriceStrategy(PriceStrategy.TOTAL);
        BigDecimal totalValue = new BigDecimal(0);
        totalPrice.setValue(resolveValue(totalValue, product.getCategory()));
        return totalPrice;
    }

    private BigDecimal resolveValue(BigDecimal totalValue, Category category) {
        switch (category.getPrice().getPriceStrategy()) {
            case TOTAL:
            case SKIP:
                break;
            case PERCENTAGE:
                totalValue = totalValue.multiply(category.getPrice().getValue().divide(new BigDecimal(100)));
                break;
            case SUMMARY:
                totalValue = totalValue.add(category.getPrice().getValue());
                break;
            case BASE:
                totalValue = totalValue.add(category.getPrice().getValue());
                //TODO decide how to resolve chains
                break;
            case REWRITE:
                //TODO decide how to resolve chains
                totalValue = category.getPrice().getValue();
                break;
            default:
                throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknow Price Stratagy");
        }
        if (category.getChildrenCategoryList() != null) {
            for (Category category1 : category.getChildrenCategoryList()) {
                resolveValue(totalValue, category1);
            }
        }
        return totalValue;
    }


    private Category generateCategory(ProductCategory rootCategory, ProductCategory subCategory) {
        return (Category) ApplicationContext
                .getGenericFactoryMap()
                .get(ApplicationInstanceType.CATEGORY)
                .get(Arrays.asList(rootCategory, subCategory));
    }
}
