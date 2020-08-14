package com.example.taiwanweatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MenuItem;

import com.example.taiwanweatherapp.viewmodels.Fragment_Home_ViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    MyService myService;
    private Fragment_Home_ViewModel mfragment_home_viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView BottomNav = findViewById(R.id.bottom_navigation);
        BottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        //set initial fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_Home()).commit();
        //init ViewModel


        startService(new Intent(this, MyService.class));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MyService.class));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.item_home:
                            selectedFragment = new Fragment_Home();
                            break;
                        case R.id.item_map:
                            selectedFragment = new Fragment_Map();
                            break;
                        case R.id.item_weather:
                            selectedFragment = new Fragment_Weather();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }

            };


}