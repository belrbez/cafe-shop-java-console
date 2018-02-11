package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.domain.entity.Option;
import ru.testing.cofeeshop.domain.entity.Price;
import ru.testing.cofeeshop.domain.value.OptionType;
import ru.testing.cofeeshop.domain.value.ProductCategory;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

public class OptionFactory extends GenericFactory<Option, OptionType> {

    private static Long numberOfCategory = 0L;

    @Override
    public Option get(OptionType optionType) {
        Option option = new Option();
        option.setName(String.format("%s %s", optionType.toString(), numberOfCategory));
        option.setType(optionType);
        generateOptionWithPrice(option, optionType);
        numberOfCategory++;
        return option;
    }

    private void generateOptionWithPrice(Option option, OptionType optionType) {
        switch (optionType) {
            case FAT_CONTENT:
                generatePrice(option, ProductCategory.MILK_ADD_ON);
                break;
            case SUGAR_CONTENT:
                generatePrice(option, ProductCategory.SWEET_ADD_ON);
                break;
            case VOLUME:
                generatePrice(option, ProductCategory.CUP);
                break;
            default:
                throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknown Option to create!");
        }
    }

    private void generatePrice(Option option, ProductCategory productCategory) {
        option.setPrice((Price) ApplicationContext
                .getGenericFactoryMap()
                .get(ApplicationInstanceType.PRICE)
                .get(productCategory));
    }
}
