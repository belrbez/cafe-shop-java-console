package ru.testing.cofeeshop.utils.reliability;

public class OperationException extends RuntimeException {

    private final OperationResultStatus status;

    public OperationException(final OperationResultStatus status) {
        this(status, null);
    }

    public OperationException(final OperationResultStatus status, final String description) {
        this(status, description, null);
    }

    public OperationException(final OperationResultStatus status, final String description, final Throwable cause) {
        super(description, cause);
        this.status = status;
    }

    public OperationResultStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return String.format("%s: %s", status.getCode(), super.getMessage() != null ? super.getMessage() : status.getDefaultDescription());
    }
}
