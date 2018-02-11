package ru.testing.cofeeshop.utils.reliability;

public enum OperationResultStatus {

    SUCCESS_CREATED(101, "New data has been successfully created and persisted"),

    SUCCESS_UPDATED(102, "Requested data has been successfully updated and persisted"),

    SUCCESS_RETRIEVED(103, "Requested data has been successfully retrieved"),

    SUCCESS_DELETED(104, "Requested data has been successfully deleted"),

    FAILURE_VALIDATION(202, "Operation cannot be completed due to input validation failure"),

    FAILURE_LOGIC_SEARCH_CRITERIA(301, "Operation cannot be completed due to illegal search criteria"),

    FAILURE_LOGIC_DATA_CONSISTENCY(302, "Operation cannot be completed due to data consistency constraints"),

    FAILURE_LOGIC_UPDATE_REJECTED(305, "Operation cannot be completed due to data update rejection"),

    FAILURE_LOGIC_DELETE_REJECTED(305, "Operation cannot be completed due to data deletion rejection"),

    FAILURE_LOGIC_RECORD_NOT_FOUND(309, "Operation cannot be completed due to missing of requested data"),

    FAILURE_LOGIC_NOT_AUTHORIZED(310, "Operation cannot be completed due to insufficient authorization"),

    FAILURE_INTERNAL_DATASOURCE_CONNECTION(401, "Operation has been interrupted due to database connectivity problem"),

    FAILURE_INTERNAL_TOO_MANY_OPERATIONS(402, "Operation has been interrupted due to current service overload"),

    FAILURE_INTERNAL_RESOURCE_NOT_FOUND(403, "Operation has been interrupted due to missing of required resource"),

    FAILURE_INTERNAL_KILLBILL_CONNECTION(404, "Operation has been interrupted due to KillBill connectivity problem"),

    FAILURE_INTERNAL_UNKNOWN(500, "Operation has been interrupted by an unexpected error");

    private final Integer code;
    private final String defaultDescription;

    OperationResultStatus(final Integer code, final String defaultDescription) {
        this.code = code;
        this.defaultDescription = defaultDescription;
    }

    public Integer getCode() {
        return code;
    }

    public String getDefaultDescription() {
        return defaultDescription;
    }
}
