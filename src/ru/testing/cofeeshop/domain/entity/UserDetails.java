package ru.testing.cofeeshop.domain.entity;

public class UserDetails extends GenericIdContainer {

    private String username;

    private String country;

    private Basket basket = new Basket();

    public UserDetails(String username, String country) {
        this.username = username;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
