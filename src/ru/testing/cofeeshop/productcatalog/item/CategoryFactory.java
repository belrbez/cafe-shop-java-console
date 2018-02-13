package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.domain.entity.Category;
import ru.testing.cofeeshop.domain.entity.Price;
import ru.testing.cofeeshop.domain.value.ProductCategory;
import ru.testing.cofeeshop.productcatalog.IdGenerator;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static ru.testing.cofeeshop.productcatalog.item.CategoryFactory.CategoryBuildStrategy.ALL_CHILDREN;

/**
 * The type Category factory.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class CategoryFactory extends GenericFactory<Category, List<ProductCategory>> {

    private static Long numberOfCategories = 0L;

    /**
     * The Category build strategy.
     */
    CategoryBuildStrategy categoryBuildStrategy = ALL_CHILDREN;

    @Override
    public Category get(List<ProductCategory> productCategoryList) {
        Category rootCategory = null;
        Iterator<ProductCategory> iterator = productCategoryList.iterator();
        if (iterator.hasNext()) {
            rootCategory = new Category();
            IdGenerator.generateAndSetId(rootCategory, numberOfCategories);
            rootCategory.setType(iterator.next());
            rootCategory.setPrice(generatePrice(rootCategory.getType()));

            switch (categoryBuildStrategy) {
                case CHAIN:
                    Category previousCategory = rootCategory;
                    while (iterator.hasNext()) {
                        Category subCategory = generateCategory(iterator.next());
                        previousCategory.setChildrenCategoryList(Collections.singletonList(subCategory));
                        previousCategory = subCategory;
                    }
                    break;
                case ALL_CHILDREN:
                    List<Category> chainOfCategory = new ArrayList<>();
                    while (iterator.hasNext()) {
                        Category subCategory = generateCategory(iterator.next());
                        chainOfCategory.add(subCategory);
                    }
                    rootCategory.setChildrenCategoryList(chainOfCategory);
                    break;
                default:
                    throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknown Category to create!");
            }
        }
        return rootCategory;
    }

    private Category generateCategory(ProductCategory productCategory) {
        Category subCategory = new Category();
        IdGenerator.generateAndSetId(subCategory, numberOfCategories);
        subCategory.setName(String.format("%s %s", productCategory.toString(), subCategory.getId()));
        subCategory.setType(productCategory);
        subCategory.setPrice(generatePrice(productCategory));
        numberOfCategories++;
        return subCategory;
    }

    private Price generatePrice(ProductCategory type) {
        return (Price) ApplicationContext
                .getGenericFactoryMap()
                .get(ApplicationInstanceType.PRICE)
                .get(type);
    }

    /**
     * Category build strategy category factory.
     *
     * @param categoryBuildStrategy the category build strategy
     * @return the category factory
     */
    public CategoryFactory categoryBuildStrategy(CategoryBuildStrategy categoryBuildStrategy) {
        this.categoryBuildStrategy = categoryBuildStrategy;
        return this;
    }

    /**
     * The enum Category build strategy.
     */
    public enum CategoryBuildStrategy {

        /**
         * Chain category build strategy.
         */
        CHAIN,

        /**
         * All children category build strategy.
         */
        ALL_CHILDREN;
    }
}
