package ru.testing.cofeeshop.controller.mapper;

import ru.testing.cofeeshop.controller.model.CategoryDTO;
import ru.testing.cofeeshop.controller.model.OptionDTO;
import ru.testing.cofeeshop.controller.model.ProductDTO;
import ru.testing.cofeeshop.domain.entity.Category;
import ru.testing.cofeeshop.domain.entity.Option;
import ru.testing.cofeeshop.domain.entity.Product;
import ru.testing.cofeeshop.productcatalog.resource.AvailableProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Product mapper.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class ProductMapper {

    /**
     * Map product into dto product dto.
     *
     * @param product        the product
     * @param choosedProduct the choosed product
     * @return the product dto
     */
    public static ProductDTO mapProductIntoDTO(Product product, AvailableProduct choosedProduct) {
        ProductDTO productDTO = mapProductIntoDTO(product);
        List<ProductDTO> addons = new ArrayList<>();
        if (product.getAddOns() != null) {
            for (Product product1 : product.getAddOns()) {
                addons.add(mapProductIntoDTO(product1));
            }
            productDTO.setAddOns(addons);
        }
        productDTO.setAvailableProduct(choosedProduct);
        return productDTO;
    }

    /**
     * Map product into dto product dto.
     *
     * @param product the product
     * @return the product dto
     */
    public static ProductDTO mapProductIntoDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTotalCost(product.getPrice().getValue());
        productDTO.setCategory(mapCategoryIntoDto(product.getCategory()));
        productDTO.setName(product.getName());
        productDTO.setAvailableProduct(AvailableProduct.fromContainsValue(product.getName()));
        return productDTO;
    }


    /**
     * Map category into dto category dto.
     *
     * @param category the category
     * @return the category dto
     */
    public static CategoryDTO mapCategoryIntoDto(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setType(category.getType());
        categoryDTO.setChildrenCategoryList(mapCategoryIntoDtoList(category.getChildrenCategoryList()));
        categoryDTO.setOptionList(mapOptionIntoDtoList(category.getOptionList()));
        return categoryDTO;
    }

    /**
     * Map category into dto list list.
     *
     * @param categoryList the category list
     * @return the list
     */
    public static List<CategoryDTO> mapCategoryIntoDtoList(List<Category> categoryList) {
        if (categoryList == null) {
            return null;
        }
        List<CategoryDTO> categoryDTOList = new ArrayList<>(categoryList.size());
        for (Category category : categoryList) {
            categoryDTOList.add(mapCategoryIntoDto(category));
        }
        return categoryDTOList;
    }

    /**
     * Map option into dto list list.
     *
     * @param optionList the option list
     * @return the list
     */
    public static List<OptionDTO> mapOptionIntoDtoList(List<Option> optionList) {
        if (optionList == null) {
            return null;
        }
        List<OptionDTO> optionDTOList = new ArrayList<>(optionList.size());
        for (Option option : optionList) {
            optionDTOList.add(mapOptionIntoDto(option));
        }
        return optionDTOList;
    }

    /**
     * Map option into dto option dto.
     *
     * @param option the option
     * @return the option dto
     */
    public static OptionDTO mapOptionIntoDto(Option option) {
        if (option == null) {
            return null;
        }
        OptionDTO optionDTO = new OptionDTO();
        optionDTO.setName(option.getName());
        optionDTO.setValue(option.getValue());
        optionDTO.setType(option.getType());
        optionDTO.setPrice(option.getPrice().getValue());
        return optionDTO;
    }
}
