package ru.testing.cofeeshop.config;

import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.entity.UserDetails;
import ru.testing.cofeeshop.productcatalog.FactoryProducer;
import ru.testing.cofeeshop.productcatalog.item.GenericFactory;
import ru.testing.cofeeshop.utils.reliability.OperationException;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext extends ApplicationInstance {

    private final static Map<ApplicationInstanceType, GenericFactory> genericFactoryMap;
    private static UserDetails userDetails;
    //to use multithreading ConcurrentHashMap
    private static Map<Long, Order> orderHistory;

    static {
        orderHistory = new HashMap<>();
        genericFactoryMap = new HashMap<>();
        for (ApplicationInstanceType b : ApplicationInstanceType.values()) {
            try {
                GenericFactory genericfactory = FactoryProducer.getFactory(b);
                if (genericfactory != null) {
                    genericFactoryMap.put(b, genericfactory);
                }
            } catch (OperationException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ApplicationContext(UserDetails userDetails) {
        ApplicationContext.userDetails = userDetails;
    }

    public static Map<Long, Order> getOrderHistory() {
        return orderHistory;
    }

    public static Map<ApplicationInstanceType, GenericFactory> getGenericFactoryMap() {
        return genericFactoryMap;
    }

    public static UserDetails getUserDetails() {
        return userDetails;
    }

    public static class ApplicationContextBuilder {

        private UserDetails userDetails;

        public ApplicationContextBuilder() {
        }

        public ApplicationContextBuilder setDefaultUserDetails() {
            userDetails = new UserDetails("Client", "Russian Federation");
            return this;
        }

        public ApplicationContext build() {
            if (userDetails == null) {
                setDefaultUserDetails();
            }
            return new ApplicationContext(userDetails);
        }
    }
}
