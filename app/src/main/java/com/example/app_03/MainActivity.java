package com.example.app_03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app_03.activities.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLARACIONES
        Intent intentToSecondActivity = new Intent(this, SecondActivity.class);
        Intent intentToNavigator = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
        Intent  intentCallPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 123456789"));

        Button btnToNavigator = findViewById(R.id.BtnToNavigator);
        Button btnCellPhone = findViewById(R.id.btnCellPhone);
        Button btnToSecondActivity = findViewById(R.id.btnSecondActivity);


        btnToSecondActivity.setOnClickListener(v->{
            intentToSecondActivity.putExtra("usuario", "Felix");
            startActivity(intentToSecondActivity);
        });

        //Clicks(btnToSecondActivity, intentToSecondActivity);
        Clicks(btnToNavigator, intentToNavigator);
        Clicks(btnCellPhone, intentCallPhone);
    }

    void Clicks(Button btn, Intent intent){
        btn.setOnClickListener(v->{
            startActivity(intent);
        });
    }
}