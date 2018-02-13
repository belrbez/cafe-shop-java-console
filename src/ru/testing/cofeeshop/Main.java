package ru.testing.cofeeshop;

import ru.testing.cofeeshop.app.console.BillingCycleUI;
import ru.testing.cofeeshop.config.ApplicationContextHolder;
import ru.testing.cofeeshop.config.value.ApplicationMode;

/**
 * The type Main.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new ApplicationContextHolder()
                .applicationMode(ApplicationMode.DEMONSTRATION)
                .initialize();
        BillingCycleUI.initialize();
    }
}
