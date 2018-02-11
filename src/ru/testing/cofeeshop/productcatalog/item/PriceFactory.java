package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.domain.entity.Price;
import ru.testing.cofeeshop.domain.value.PriceStrategy;
import ru.testing.cofeeshop.domain.value.ProductCategory;
import ru.testing.cofeeshop.productcatalog.IdGenerator;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

import java.math.BigDecimal;

public class PriceFactory extends GenericFactory<Price, ProductCategory> {

    private static Long numberOfPrices = 0L;

    @Override
    public Price get(ProductCategory productCategory) {
        Price price = new Price();
        IdGenerator.generateAndSetId(price, numberOfPrices);
        resolvePriceValueAndStrategy(price, productCategory);
        numberOfPrices++;
        return price;
    }

    private void resolvePriceValueAndStrategy(Price price, ProductCategory productCategory) {
        switch (productCategory) {
            case TEA:
                price.setPriceStrategy(PriceStrategy.BASE);
                price.setValue(new BigDecimal(50));
                break;
            case GREEN_TEA:
                price.setPriceStrategy(PriceStrategy.SKIP);
                price.setValue(new BigDecimal(0));
                break;
            case WHITE_TEA:
                price.setPriceStrategy(PriceStrategy.SKIP);
                price.setValue(new BigDecimal(0));
                break;
            case BLACK_TEA:
                price.setPriceStrategy(PriceStrategy.SKIP);
                price.setValue(new BigDecimal(0));
                break;
            case COFFEE:
                price.setPriceStrategy(PriceStrategy.BASE);
                price.setValue(new BigDecimal(80));
                break;
            case LATTE_COFFEE:
                price.setPriceStrategy(PriceStrategy.REWRITE);
                price.setValue(new BigDecimal(100));
                break;
            case BLACK_COFFEE:
                price.setPriceStrategy(PriceStrategy.SKIP);
                price.setValue(new BigDecimal(0));
                break;
            case ESPRESSO_COFFEE:
                price.setPriceStrategy(PriceStrategy.SUMMARY);
                price.setValue(new BigDecimal(10));
                break;
            case MILK_ADD_ON:
                price.setPriceStrategy(PriceStrategy.BASE);
                price.setValue(new BigDecimal(15));
                break;
            case CREAM:
                price.setPriceStrategy(PriceStrategy.REWRITE);
                price.setValue(new BigDecimal(20));
                break;
            case MILK:
                price.setPriceStrategy(PriceStrategy.REWRITE);
                price.setValue(new BigDecimal(15));
                break;
            case SWEET_ADD_ON:
                price.setPriceStrategy(PriceStrategy.BASE);
                price.setValue(new BigDecimal(10));
                break;
            case SUGAR:
                price.setPriceStrategy(PriceStrategy.REWRITE);
                price.setValue(new BigDecimal(5));
                break;
            case HONEY:
                price.setPriceStrategy(PriceStrategy.REWRITE);
                price.setValue(new BigDecimal(10));
                break;
            case OTHER_ADD_ON:
                price.setPriceStrategy(PriceStrategy.BASE);
                price.setValue(new BigDecimal(10));
                break;
            case LEMON:
                price.setPriceStrategy(PriceStrategy.REWRITE);
                price.setValue(new BigDecimal(10));
                break;
            case CUP:
                price.setPriceStrategy(PriceStrategy.SKIP);
                price.setValue(new BigDecimal(1));
                break;
            default:
                throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknown Price to create!");
        }


    }
}
