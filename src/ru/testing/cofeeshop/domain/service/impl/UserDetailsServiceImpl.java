package ru.testing.cofeeshop.domain.service.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.controller.mapper.ProductMapper;
import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.BasketItemDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;
import ru.testing.cofeeshop.domain.entity.Basket;
import ru.testing.cofeeshop.domain.entity.BasketItem;
import ru.testing.cofeeshop.domain.entity.UserDetails;
import ru.testing.cofeeshop.domain.service.UserDetailsService;

import java.util.HashSet;
import java.util.Set;

/**
 * The type User details service.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails updateUserDetails(UserDTO userDTO) {
        ApplicationContext.getUserDetails().setUsername(userDTO.getName());
        ApplicationContext.getUserDetails().setCountry(userDTO.getCountry());
        return ApplicationContext.getUserDetails();
    }

    @Override
    public BasketDTO getUserBasket() {
        return mapBasketIntoDto(ApplicationContext.getUserDetails().getBasket());
    }

    private BasketDTO mapBasketIntoDto(Basket basket) {
        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setSize(basket.getSize());
        basketDTO.setTotalCost(basket.getTotalCost());
        basketDTO.setItemSet(mapItemSetIntoDTO(basket.getItemSet()));
        return basketDTO;
    }

    private Set<BasketItemDTO> mapItemSetIntoDTO(Set<BasketItem> itemSet) {
        Set<BasketItemDTO> basketItemDTOSet = new HashSet<>(itemSet.size());
        for (BasketItem basketItem : itemSet) {
            basketItemDTOSet.add(mapBasketItemIntoDTO(basketItem));
        }
        return basketItemDTOSet;
    }

    private BasketItemDTO mapBasketItemIntoDTO(BasketItem basketItem) {
        BasketItemDTO basketItemDTO = new BasketItemDTO();
        basketItemDTO.setAmount(basketItem.getAmount());
        basketItemDTO.setProductDTO(ProductMapper.mapProductIntoDTO(basketItem.getProduct()));
        return basketItemDTO;
    }
}
