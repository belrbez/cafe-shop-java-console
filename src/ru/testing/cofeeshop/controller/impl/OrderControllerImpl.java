package ru.testing.cofeeshop.controller.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.controller.OrderController;
import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.service.OrderService;
import ru.testing.cofeeshop.domain.value.PaymentType;

/**
 * The type Order controller.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class OrderControllerImpl extends GenericController implements OrderController {

    @Override
    public Order processOrder(PaymentType paymentType) {
        return ((OrderService) ApplicationContext.getGenericServiceMap().get(ApplicationInstanceType.ORDER)).processOrder(paymentType);
    }
}
