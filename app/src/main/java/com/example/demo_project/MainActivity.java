package com.example.demo_project;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.hom) {
            fragment = new IndexHomeFragment();
        } else if (item.getItemId() == R.id.settings) {
            fragment = new SettingsFragment();
        } else if (item.getItemId() == R.id.photo) {
            fragment = new PhotoFragment();
        }
        assert fragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
        return true;
    };
    private DrawerLayout drawerLayout;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.extra_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navmenu);

        drawerLayout = findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId() == R.id.hom) {
                fragment = new NavHomeFragment();
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if (item.getItemId() == R.id.settings) {
                fragment = new NavSettingsFragment();
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if (item.getItemId() == R.id.photo) {
                fragment = new NavPhotoFragment();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
            return true;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new IndexHomeFragment()).commit();
    }
}