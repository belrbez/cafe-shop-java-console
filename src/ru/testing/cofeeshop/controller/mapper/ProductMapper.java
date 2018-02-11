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

public class ProductMapper {

    public static ProductDTO mapProductIntoDTO(Product product, AvailableProduct choosedProduct) {
        ProductDTO productDTO = mapProductIntoDTO(product);
        productDTO.setAvailableProduct(choosedProduct);
        return productDTO;
    }

    public static ProductDTO mapProductIntoDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTotalCost(product.getPrice().getValue());
        productDTO.setCategory(mapCategoryIntoDto(product.getCategory()));
        productDTO.setName(product.getName());
        return productDTO;
    }


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
