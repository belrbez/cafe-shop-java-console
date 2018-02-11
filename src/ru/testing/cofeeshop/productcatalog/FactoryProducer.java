package ru.testing.cofeeshop.productcatalog;

import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.productcatalog.item.*;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

public class FactoryProducer {

    public static GenericFactory getFactory(ApplicationInstanceType choice) {
        switch (choice) {
            case BASKET:
            case BASKET_ITEM:
                break;
            case PRODUCT:
                return new ProductFactory();
            case CATEGORY:
                return new CategoryFactory();
            case OPTION:
                return new OptionFactory();
            case PRICE:
                return new PriceFactory();
            case ORDER:
                return new OrderFactory();
            default:
                throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, String.format("Unknown item type %s!", choice));
        }
//        throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, String.format("There is no implementation for that type %s!", choice));
        return null;
    }
}
