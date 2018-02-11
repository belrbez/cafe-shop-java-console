package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;
import ru.testing.cofeeshop.domain.entity.UserDetails;

public interface UserDetailsService {

    UserDetails updateUserDetails(UserDTO userDTO);

    BasketDTO getUserBasket();
}
