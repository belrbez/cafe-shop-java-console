package ru.testing.cofeeshop.controller;

import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;

public interface UserController {

    void updateUser(UserDTO toSave);

    BasketDTO getBasket();
}
