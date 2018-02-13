package ru.testing.cofeeshop.domain.value;

/**
 * The enum Price strategy.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public enum PriceStrategy {

    /**
     * Total price strategy.
     */
    TOTAL,

    /**
     * Skip price strategy.
     */
    SKIP,

    /**
     * Base price strategy.
     */
    BASE,

    /**
     * Summary price strategy.
     */
    SUMMARY,

    /**
     * Rewrite price strategy.
     */
    REWRITE,

    /**
     * Percentage price strategy.
     */
    PERCENTAGE;
}
