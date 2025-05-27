package com.example.app_03.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app_03.R;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = "LOG_SECONDACTICITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //DECLARACIONES
        TextView txtBienvenida = findViewById(R.id.txtBienvenida);
        String userName = getIntent().getStringExtra("usuario");

        String bienvenida = "Bienvenido: ";

        Log.i(LOG_TAG, "El usuario que recibo desde mi MainActivity es: " + userName);

        txtBienvenida.setText(bienvenida + userName);
    }
}