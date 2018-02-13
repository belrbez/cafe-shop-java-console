package ru.testing.cofeeshop.controller.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.controller.UserController;
import ru.testing.cofeeshop.controller.model.BasketDTO;
import ru.testing.cofeeshop.controller.model.UserDTO;

/**
 * The type User controller.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class UserControllerImpl extends GenericController implements UserController {

    @Override
    public void updateUser(UserDTO toSave) {
        ApplicationContext.getUserDetailsService().updateUserDetails(toSave);
    }

    @Override
    public BasketDTO getBasket() {
        return ApplicationContext.getUserDetailsService().getUserBasket();
    }
}
