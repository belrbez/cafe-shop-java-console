package ru.testing.cofeeshop.config;

import ru.testing.cofeeshop.config.value.ApplicationMode;
import ru.testing.cofeeshop.utils.reliability.NotImplementedException;
import ru.testing.cofeeshop.utils.reliability.OperationException;
import ru.testing.cofeeshop.utils.reliability.OperationResultStatus;

public class ApplicationContextHolder {

    private static volatile ApplicationContext applicationContext;
    private ApplicationMode applicationMode;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void initialize() {
        if (applicationContext == null) {
            synchronized (ApplicationContextHolder.class) {
                if (applicationContext == null) {
                    switch (this.applicationMode) {
                        case PRODUCTION:
                            throw new NotImplementedException("Production mode has not been implemented yet!");
                        case DEMONSTRATION:
                            applicationContext = new ApplicationContext
                                    .ApplicationContextBuilder()
                                    .setDefaultUserDetails()
                                    .build();
                            break;
                        default:
                            throw new OperationException(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, "Unknown startup mode!");
                    }
                }
            }
        }
    }

    public ApplicationContextHolder applicationMode(ApplicationMode applicationMode) {
        this.applicationMode = applicationMode;
        return this;
    }

    public ApplicationMode getApplicationMode() {
        return this.applicationMode;
    }
}
