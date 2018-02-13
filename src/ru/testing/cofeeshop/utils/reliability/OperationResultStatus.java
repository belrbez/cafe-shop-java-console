package ru.testing.cofeeshop.utils.reliability;

/**
 * The enum Operation result status.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public enum OperationResultStatus {

    /**
     * The Success created.
     */
    SUCCESS_CREATED(101, "New data has been successfully created and persisted"),

    /**
     * The Success updated.
     */
    SUCCESS_UPDATED(102, "Requested data has been successfully updated and persisted"),

    /**
     * The Success retrieved.
     */
    SUCCESS_RETRIEVED(103, "Requested data has been successfully retrieved"),

    /**
     * The Success deleted.
     */
    SUCCESS_DELETED(104, "Requested data has been successfully deleted"),

    /**
     * The Failure validation.
     */
    FAILURE_VALIDATION(202, "Operation cannot be completed due to input validation failure"),

    /**
     * The Failure logic search criteria.
     */
    FAILURE_LOGIC_SEARCH_CRITERIA(301, "Operation cannot be completed due to illegal search criteria"),

    /**
     * The Failure logic data consistency.
     */
    FAILURE_LOGIC_DATA_CONSISTENCY(302, "Operation cannot be completed due to data consistency constraints"),

    /**
     * The Failure logic update rejected.
     */
    FAILURE_LOGIC_UPDATE_REJECTED(305, "Operation cannot be completed due to data update rejection"),

    /**
     * The Failure logic delete rejected.
     */
    FAILURE_LOGIC_DELETE_REJECTED(305, "Operation cannot be completed due to data deletion rejection"),

    /**
     * The Failure logic record not found.
     */
    FAILURE_LOGIC_RECORD_NOT_FOUND(309, "Operation cannot be completed due to missing of requested data"),

    /**
     * The Failure logic not authorized.
     */
    FAILURE_LOGIC_NOT_AUTHORIZED(310, "Operation cannot be completed due to insufficient authorization"),

    /**
     * The Failure internal datasource connection.
     */
    FAILURE_INTERNAL_DATASOURCE_CONNECTION(401, "Operation has been interrupted due to database connectivity problem"),

    /**
     * The Failure internal too many operations.
     */
    FAILURE_INTERNAL_TOO_MANY_OPERATIONS(402, "Operation has been interrupted due to current service overload"),

    /**
     * The Failure internal resource not found.
     */
    FAILURE_INTERNAL_RESOURCE_NOT_FOUND(403, "Operation has been interrupted due to missing of required resource"),

    /**
     * The Failure internal killbill connection.
     */
    FAILURE_INTERNAL_KILLBILL_CONNECTION(404, "Operation has been interrupted due to KillBill connectivity problem"),

    /**
     * The Failure internal unknown.
     */
    FAILURE_INTERNAL_UNKNOWN(500, "Operation has been interrupted by an unexpected error");

    private final Integer code;
    private final String defaultDescription;

    OperationResultStatus(final Integer code, final String defaultDescription) {
        this.code = code;
        this.defaultDescription = defaultDescription;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets default description.
     *
     * @return the default description
     */
    public String getDefaultDescription() {
        return defaultDescription;
    }
}
