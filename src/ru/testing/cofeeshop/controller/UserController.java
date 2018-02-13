package ru.testing.cofeeshop.controller;

import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;

/**
 * The interface User controller.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public interface UserController {

    /**
     * Update user.
     *
     * @param toSave the to save
     */
    void updateUser(UserDTO toSave);

    /**
     * Gets basket.
     *
     * @return the basket
     */
    BasketDTO getBasket();
}
