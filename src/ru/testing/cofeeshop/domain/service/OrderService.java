package ru.testing.cofeeshop.domain.service;

import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.value.PaymentType;

public interface OrderService {

    Order processOrder(PaymentType paymentType);
}
