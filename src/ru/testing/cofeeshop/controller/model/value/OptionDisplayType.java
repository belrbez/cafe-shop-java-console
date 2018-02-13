package ru.testing.cofeeshop.controller.model.value;

/**
 * The enum Option display type.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public enum OptionDisplayType {

    /**
     * Fat content option display type.
     */
    FAT_CONTENT("%"),

    /**
     * Sugar content option display type.
     */
    SUGAR_CONTENT(""),

    /**
     * Volume option display type.
     */
    VOLUME("мл.");

    private String value;

    OptionDisplayType(String value) {
        this.value = value;
    }

    /**
     * From value option display type.
     *
     * @param text the text
     * @return the option display type
     */
    public static OptionDisplayType fromValue(String text) {
        for (OptionDisplayType b : OptionDisplayType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
