package org.example.model;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    // getters and setters


    public String getName() {
        return name;
    }



    public int getId() {
        return id;
    }



    public String getCategory() {
        return category;
    }



    public double getPrice() {
        return price;
    }



    public int getQuantity() {
        return quantity;
    }



    // constructor
    public Product(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}
