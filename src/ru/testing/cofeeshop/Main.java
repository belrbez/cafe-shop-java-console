package ru.testing.cofeeshop;

import ru.testing.cofeeshop.app.console.BillingCycleUI;
import ru.testing.cofeeshop.config.ApplicationContextHolder;
import ru.testing.cofeeshop.config.value.ApplicationMode;

public class Main {

    public static void main(String[] args) {
        new ApplicationContextHolder()
                .applicationMode(ApplicationMode.DEMONSTRATION)
                .initialize();
        BillingCycleUI.initialize();
    }
}
