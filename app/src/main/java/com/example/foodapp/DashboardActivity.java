package com.example.foodapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.contener,
                new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;


                    if (item.getItemId() == R.id.home) {
                        selectedFragment = new HomeFragment();
                    } else if (item.getItemId() == R.id.search) {
                        selectedFragment = new SarchFragment();
                    } else if (item.getItemId() == R.id.savat) {
                        selectedFragment = new SavatFragment();
                    } else if (item.getItemId() == R.id.profile) {
                        selectedFragment = new ProfileFragment();
                    }


                    if (selectedFragment != null) {



                        getSupportFragmentManager().beginTransaction().replace(R.id.contener,
                                selectedFragment).commit();
                    }

                    return true;
                }
            };
}