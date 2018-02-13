package ru.testing.cofeeshop.utils.reliability;

/**
 * The type Not implemented exception.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class NotImplementedException extends OperationException {

    private static final String DEFAULT_MESSAGE = "Not imlemented!";

    /**
     * Instantiates a new Not implemented exception.
     */
    public NotImplementedException() {
        super(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new Not implemented exception.
     *
     * @param description the description
     */
    public NotImplementedException(String description) {
        super(OperationResultStatus.FAILURE_INTERNAL_UNKNOWN, description);
    }
}
