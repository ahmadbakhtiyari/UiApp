package com.example.uichallenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.uichallenge.adapter.RecycleAdapter;
import com.example.uichallenge.fragments.HomeFragment;
import com.example.uichallenge.fragments.JashnvarehFragment;
import com.example.uichallenge.fragments.ScanFragment;
import com.example.uichallenge.fragments.TarakoneshFragment;
import com.example.uichallenge.model.ItemModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nv);

        Fragment home = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FrameLayout , home);
        transaction.commit();


        bottomNavigationView.setSelectedItemId(R.id.home_menu);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home_menu:
                        Fragment home = new HomeFragment();
                        setFragment(home);
                        break;
                    case R.id.jashnvare:
                        Fragment Jashnvareh = new JashnvarehFragment();
                        setFragment(Jashnvareh);
                        break;
                    case R.id.scan:
                        Fragment Scan = new ScanFragment();
                        setFragment(Scan);
                        break;
                    case R.id.tarakonesh:
                        Fragment Tarakonesh = new TarakoneshFragment();
                        setFragment(Tarakonesh);
                        break;
                }

                return true;
            }



            public void setFragment(Fragment fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.FrameLayout, fragment);
                transaction.commit();
            }

        });


    }


}
