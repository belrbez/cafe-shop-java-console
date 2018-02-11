package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.config.ApplicationContext;
import ru.testing.cofeeshop.domain.entity.BasketItem;
import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.value.PaymentType;
import ru.testing.cofeeshop.productcatalog.IdGenerator;

import java.io.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

public class OrderFactory extends GenericFactory<Order, PaymentType> {

    private static Long numberOfOrders = 0L;

    @Override
    public Order get(PaymentType paymentType) {
        Order order = new Order();
        IdGenerator.generateAndSetId(order, numberOfOrders);
        order.setPaymentType(paymentType);
        order.setCreatedAt(OffsetDateTime.now());
        order.setProductsSnapshotList(deepCloneBasketList(ApplicationContext.getUserDetails().getBasket().getItemSet()));
        order.setTotalCost(ApplicationContext.getUserDetails().getBasket().getTotalCost());
        numberOfOrders++;
        return order;
    }

    private Set<BasketItem> deepCloneBasketList(Set<BasketItem> itemSet) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(itemSet); //Serializes the drawing.shapes

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (HashSet<BasketItem>) ois.readObject(); //Deserializing and reading
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
