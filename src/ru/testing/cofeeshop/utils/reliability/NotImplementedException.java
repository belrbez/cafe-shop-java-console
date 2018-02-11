package ru.testing.cofeeshop.utils.reliability;

public class NotImplementedException extends OperationException {

    private static final String DEFAULT_MESSAGE = "Not imlemented!";

    public NotImplementedException() {
        super(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, DEFAULT_MESSAGE);
    }

    public NotImplementedException(String description) {
        super(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, description);
    }
}
