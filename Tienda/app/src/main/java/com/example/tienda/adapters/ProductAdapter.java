package com.example.tienda.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private List<Product> products;

    public ProductAdapter(List<Product> products){
        this.products = products;
    }

    // Crear nuevas vistas (Invocadas por el Layout Manager)
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }


    // Reemplazar el contenido de una vista (invocada por el layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Product product = products.get(position);
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText("$" + product.getPrice());

        holder.btnShowProduct.setOnClickListener(v->{
            Toast.makeText(v.getContext(),"Producto Clickeado: " + product.getName(), Toast.LENGTH_SHORT).show();
        });

    }


    // Devuelve la cantidad de elementos que tenemos en la lista
    @Override
    public int getItemCount(){
        return products.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPrice;

        Button btnShowProduct;

        public ViewHolder(View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnShowProduct = itemView.findViewById(R.id.btnShowProduct);
        }
    }
}