package com.thomasbayer.sqlrest;

public class Customer {
    private int id;
    private String firstName, lastName;
    private String street, city;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String firstName, String lastName,
                    String street, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return String.format("Customer[#%s: %s, %s -- %s, %s]",
                            id, lastName, firstName, street, city);
    }
}
