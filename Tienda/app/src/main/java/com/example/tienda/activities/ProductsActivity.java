package com.example.tienda.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.adapters.ProductAdapter;
import com.example.tienda.models.Product;
import com.example.tienda.services.ProductsServices;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    static String TAG = "Listado";
    private RecyclerView rvProducts;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        // RecyclerView: Componente eficiente para mostrar listas grandes. Reutilización de Vistas (ViewHolder)
        // Adapters: Puente entre los datos y las vistas. Decide cómo mostrar los elementos.
        // ViewHolder: Contiene las referencias a las vistas de cada fila. (TextView/EditText/Button)

        rvProducts = findViewById(R.id.rvProducts);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        // Obtener la lista de productos
        List<Product> products = ProductsServices.getProducts();

        adapter = new ProductAdapter(products);
        rvProducts.setAdapter(adapter);
    }
}