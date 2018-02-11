package ru.testing.cofeeshop.config;

import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.controller.UserController;
import ru.testing.cofeeshop.controller.impl.GenericController;
import ru.testing.cofeeshop.controller.impl.OrderControllerImpl;
import ru.testing.cofeeshop.controller.impl.ProductControllerImpl;
import ru.testing.cofeeshop.controller.impl.UserControllerImpl;
import ru.testing.cofeeshop.domain.service.UserDetailsService;
import ru.testing.cofeeshop.domain.service.impl.GenericService;
import ru.testing.cofeeshop.domain.service.impl.OrderServiceImpl;
import ru.testing.cofeeshop.domain.service.impl.ProductServiceImpl;
import ru.testing.cofeeshop.domain.service.impl.UserDetailsServiceImpl;

import java.util.HashMap;
import java.util.Map;

public abstract class ApplicationInstance {

    private final static Map<ApplicationInstanceType, GenericController> genericControllerMap;

    private final static Map<ApplicationInstanceType, GenericService> genericServiceMap;

    private final static UserDetailsService userDetailsService;

    private final static UserController userController;

    static {
        genericControllerMap = new HashMap<>();
        genericControllerMap.put(ApplicationInstanceType.PRODUCT, new ProductControllerImpl());
        genericControllerMap.put(ApplicationInstanceType.ORDER, new OrderControllerImpl());

        genericServiceMap = new HashMap<>();
        genericServiceMap.put(ApplicationInstanceType.PRODUCT, new ProductServiceImpl());
        genericServiceMap.put(ApplicationInstanceType.ORDER, new OrderServiceImpl());

        userController = new UserControllerImpl();
        userDetailsService = new UserDetailsServiceImpl();
    }

    public static Map<ApplicationInstanceType, GenericController> getGenericControllerMap() {
        return genericControllerMap;
    }

    public static Map<ApplicationInstanceType, GenericService> getGenericServiceMap() {
        return genericServiceMap;
    }

    public static UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public static UserController getUserController() {
        return userController;
    }
}
