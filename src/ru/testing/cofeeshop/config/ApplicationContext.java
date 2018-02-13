package ru.testing.cofeeshop.config;

import ru.testing.cofeeshop.config.value.ApplicationInstanceType;
import ru.testing.cofeeshop.domain.entity.Order;
import ru.testing.cofeeshop.domain.entity.UserDetails;
import ru.testing.cofeeshop.productcatalog.FactoryProducer;
import ru.testing.cofeeshop.productcatalog.item.GenericFactory;
import ru.testing.cofeeshop.utils.reliability.OperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Application context.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
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

    /**
     * Instantiates a new Application context.
     *
     * @param userDetails the user details
     */
    public ApplicationContext(UserDetails userDetails) {
        ApplicationContext.userDetails = userDetails;
    }

    /**
     * Gets order history.
     *
     * @return the order history
     */
    public static Map<Long, Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Gets generic factory map.
     *
     * @return the generic factory map
     */
    public static Map<ApplicationInstanceType, GenericFactory> getGenericFactoryMap() {
        return genericFactoryMap;
    }

    /**
     * Gets user details.
     *
     * @return the user details
     */
    public static UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     * The type Application context builder.
     */
    public static class ApplicationContextBuilder {

        private UserDetails userDetails;

        /**
         * Instantiates a new Application context builder.
         */
        public ApplicationContextBuilder() {
        }

        /**
         * Sets default user details.
         *
         * @return the default user details
         */
        public ApplicationContextBuilder setDefaultUserDetails() {
            userDetails = new UserDetails("Client", "Russian Federation");
            return this;
        }

        /**
         * Build application context.
         *
         * @return the application context
         */
        public ApplicationContext build() {
            if (userDetails == null) {
                setDefaultUserDetails();
            }
            return new ApplicationContext(userDetails);
        }
    }
}
