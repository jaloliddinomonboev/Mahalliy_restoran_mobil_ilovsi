package com.example.foodapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detal);
        ImageView foodImage = findViewById(R.id.detalFoodImage);
        TextView foodName = findViewById(R.id.nomiDetal);
        TextView foodNarxi = findViewById(R.id.narxDetal);
        TextView foodHaqida = findViewById(R.id.foodHaqidaDetal);


        String name = getIntent().getStringExtra("foodName");
        int narxi = getIntent().getIntExtra("foodNarxi", 0);
        String haqida = getIntent().getStringExtra("foodHaqida");
        String rasmi = getIntent().getStringExtra("foodRasmi");
        String rasm = getIntent().getStringExtra("foodRasmi");

        foodName.setText(name);
        foodNarxi.setText(String.format("%d so'm", narxi));
        foodHaqida.setText(haqida);


        int imageResId = getResources().getIdentifier(rasmi, "drawable", getPackageName());
        foodImage.setImageResource(imageResId);


    }
}