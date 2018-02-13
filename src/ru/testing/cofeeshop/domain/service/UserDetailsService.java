package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;
import ru.testing.cofeeshop.domain.entity.UserDetails;

/**
 * The interface User details service.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public interface UserDetailsService {

    /**
     * Update user details user details.
     *
     * @param userDTO the user dto
     * @return the user details
     */
    UserDetails updateUserDetails(UserDTO userDTO);

    /**
     * Gets user basket.
     *
     * @return the user basket
     */
    BasketDTO getUserBasket();
}
