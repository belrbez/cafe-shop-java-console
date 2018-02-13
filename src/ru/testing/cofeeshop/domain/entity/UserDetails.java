package ru.testing.cofeeshop.domain.entity;

/**
 * The type User details.
 *
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public class UserDetails extends GenericIdContainer {

    private String username;

    private String country;

    private Basket basket = new Basket();

    /**
     * Instantiates a new User details.
     *
     * @param username the username
     * @param country  the country
     */
    public UserDetails(String username, String country) {
        this.username = username;
        this.country = country;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets basket.
     *
     * @return the basket
     */
    public Basket getBasket() {
        return basket;
    }

    /**
     * Sets basket.
     *
     * @param basket the basket
     */
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
