package com.example.tienda.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tienda.R;
import com.example.tienda.models.Product;
import com.example.tienda.services.ProductsServices;

public class AddProductActivity extends AppCompatActivity {

    private EditText etName, etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);

        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v->{

            String name = etName.getText().toString();
            double price = Double.parseDouble(etPrice.getText().toString());

            Product product = new Product(name, price);
            ProductsServices.addProduct(product);

            finish();// Cierra la actividad y vuelve al Main
        });
    }
}