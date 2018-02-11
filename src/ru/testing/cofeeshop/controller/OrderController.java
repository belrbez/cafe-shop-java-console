package ru.testing.cofeeshop.controller;

import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.value.PaymentType;

public interface OrderController {

    Order processOrder(PaymentType paymentType);
}
