package com.example.tienda.models;

public class Product {
    //private int id;
    private String name;
    private double price;

    public Product(){}

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
}