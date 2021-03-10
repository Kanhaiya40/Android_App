package com.example.demo_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.hom) {
            fragment = new HomeFragment();
        } else if (item.getItemId() == R.id.settings) {
            fragment = new SettingsFragment();
        } else if (item.getItemId() == R.id.photo) {
            fragment = new TaskManger();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        ImageFragmentAdapter imageFragmentAdapter = new ImageFragmentAdapter(getSupportFragmentManager(), 1);
        viewPager.setAdapter(imageFragmentAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new HomeFragment()).commit();
    }

}