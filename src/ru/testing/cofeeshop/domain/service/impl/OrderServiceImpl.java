package ru.testing.cofeeshop.domain.service.impl;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.service.OrderService;
import ru.testing.cofeeshop.domain.value.PaymentType;

/**
 * The type Order service.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class OrderServiceImpl extends GenericService implements OrderService {

    @Override
    public Order processOrder(PaymentType paymentType) {
        return (Order) ApplicationContext.getGenericFactoryMap().get(ApplicationInstanceType.ORDER).get(paymentType);
    }
}
