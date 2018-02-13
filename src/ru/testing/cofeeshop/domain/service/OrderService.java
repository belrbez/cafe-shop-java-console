package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.value.PaymentType;

/**
 * The interface Order service.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public interface OrderService {

    /**
     * Process order order.
     *
     * @param paymentType the payment type
     * @return the order
     */
    Order processOrder(PaymentType paymentType);
}
