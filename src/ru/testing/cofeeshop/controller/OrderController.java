package ru.testing.cofeeshop.controller;

import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.value.PaymentType;

/**
 * The interface Order controller.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public interface OrderController {

    /**
     * Process order order.
     *
     * @param paymentType the payment type
     * @return the order
     */
    Order processOrder(PaymentType paymentType);
}
