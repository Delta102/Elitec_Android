package com.example.tienda.services;

import android.util.Log;

import com.example.tienda.adapters.ProductAdapter;
import com.example.tienda.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsServices {
    private static String TAG = "Servicios";
    private static List<Product> products = new ArrayList<>();
    public static void addProduct(Product product){
        products.add(product);
    }

    public static List<Product> getProducts(){
        return products;
    }

    public static Product getProduct(int id){
        return products.get(id);
    }
    //TODO:
        // Obtener Producto Individual
        // Editar Producto
        // Eliminar Producto
}
