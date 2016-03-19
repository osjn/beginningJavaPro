package com.thomasbayer.sqlrest;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int id;
    private Customer customer;
    private double totalSum;
    private final List<Item> items;

    public Invoice(int id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    public Invoice(int id, Customer customer, double totalSum, List<Item> items) {
        this(id);
        this.customer = customer;
        this.totalSum = totalSum;
        this.items.addAll(items);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    public String toString() {
        return String.format("Invoice #%s: total sum %s" +
                "%n%s", id, totalSum, customer);
    }
}
