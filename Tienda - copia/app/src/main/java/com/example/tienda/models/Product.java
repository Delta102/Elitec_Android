package com.example.tienda.models;

public class Product {
    //private int id;
    private String name;
    private double price;
    private String imageUri;

    public Product(){}

    public Product(String name, double price, String imageUri){
        this.name = name;
        this.price = price;
        this.imageUri = imageUri;
    }

    //Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImageUri(){return imageUri;}
}