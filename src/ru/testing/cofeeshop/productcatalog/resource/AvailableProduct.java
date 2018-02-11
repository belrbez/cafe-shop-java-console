package ru.testing.cofeeshop.productcatalog.resource;


/**
 * The enum Available product.
 * <p>
 * Sub-products should contain base product name in field definition.
 */
public enum AvailableProduct {

    /**
     * The Green tea.
     */
    GREEN_TEA("Yogi Pure Green Tea"),

    /**
     * The White tea.
     */
    WHITE_TEA("Silver Needle Supreme WHITE TEA, JING"),

    /**
     * The Black tea.
     */
    BLACK_TEA("Darjeeling Black Tea"),

    /**
     * The Latte coffee.
     */
    LATTE_COFFEE("Cafe Latte"),

    /**
     * The Black coffee.
     */
    BLACK_COFFEE("BLACK Coffee Yauco Selecto AA (Puerto Rico)"),

    /**
     * The Espresso coffee.
     */
    ESPRESSO_COFFEE("Starbucks ESPRESSO Rwanda Blue Bourbon (Rwanda)"),

    /**
     * The Milk add on cream.
     */
    MILK_ADD_ON_CREAM("Kaymak Milk Cream"),

    /**
     * The Milk add on milk.
     */
    MILK_ADD_ON_MILK("Ahimsa Milk"),

    /**
     * Sweet add on sugar available product.
     */
    SWEET_ADD_ON_SUGAR("Sugar"),

    /**
     * Sweet add on honey available product.
     */
    SWEET_ADD_ON_HONEY("Honey"),

    /**
     * Other add on lemon available product.
     */
    OTHER_ADD_ON_LEMON("Lemon");

    private String value;

    AvailableProduct(String value) {
        this.value = value;
    }

    /**
     * From value available product.
     *
     * @param text the text
     * @return the available product
     */
    public static AvailableProduct fromValue(String text) {
        for (AvailableProduct b : AvailableProduct.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
