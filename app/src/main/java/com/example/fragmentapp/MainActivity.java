package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = new HomeFragment(); //yg pertama kali tampilan home
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this); //this lalu ALT+Enter pilih make main ..... lalu akan auto extends implements bottom nav pada class || juga create fungsi boolean onnavigation

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //apabila ada item yg diklik, ambil id nya
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.menu_profile:
                selectedFragment = new ProfileFragment();
                break;

        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment){
            //menempatkan fragment kedalam container
            //cek apakah aman atau tidak

            if(selectedFragment != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activitymain_container, selectedFragment)
                        .commit();
                return true;
            }
            return false;
        }
}

