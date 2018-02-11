package ru.testing.cofeeshop.controller.model.value;

public enum OptionDisplayType {

    FAT_CONTENT("%"),

    SUGAR_CONTENT(""),

    VOLUME("мл.");

    private String value;

    OptionDisplayType(String value) {
        this.value = value;
    }

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
