package com.abhiroop.multiplenavigation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.fragment.HomeFragment;
import com.abhiroop.multiplenavigation.fragment.MyMatchesFragment;
import com.abhiroop.multiplenavigation.fragment.NotificationFragment;
import com.abhiroop.multiplenavigation.fragment.SettingsFragment;
import com.abhiroop.multiplenavigation.fragment.TournamentsFragments;
import com.abhiroop.multiplenavigation.utils.MultipleNavigationConstants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean isDrawerOpen;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setUpNavigationDrawer();
        setUpBottomNavigationBar();
        fragmentManager = getSupportFragmentManager();
        loadFragment(MultipleNavigationConstants.HOME_FRAGMENT);
    }

    private void setUpBottomNavigationBar() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (id){
                    case R.id.navigation_home:
                        fragmentTransaction.replace(R.id.frame, new HomeFragment(), MultipleNavigationConstants.HOME_FRAGMENT);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.navigation_tournaments:
                        fragmentTransaction.replace(R.id.frame, new TournamentsFragments(), MultipleNavigationConstants.TOURNAMENT_FRAGMENT);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.navigation_my_matches:
                        fragmentTransaction.replace(R.id.frame, new MyMatchesFragment(), MultipleNavigationConstants.MY_MATCHES_FRAGMENTS);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.navigation_notification:
                        fragmentTransaction.replace(R.id.frame, new NotificationFragment(), MultipleNavigationConstants.NOTIFICATION_FRAGMENTS);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.navigation_settings:
                        fragmentTransaction.replace(R.id.frame, SettingsFragment.newInstance(), MultipleNavigationConstants.SETTINGS_FRAGMENTS);
                        fragmentTransaction.commit();
                        return true;
                }
                return true;
            }
        });
    }

    private void setUpToolBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        /*ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        actionbar.setDisplayHomeAsUpEnabled(true);*/
    }

    private void setUpNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.about:
                        return true;
                    case R.id.records:
                        return true;
                    case R.id.wallet:
                        return true;
                    case R.id.transaction:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();    switch(itemId) {
            // Android home
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                isDrawerOpen = true;
                return true;
        }    return true;
    }

    private void loadFragment(String tag){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, new HomeFragment(), tag);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(isDrawerOpen){
            drawerLayout.closeDrawer(GravityCompat.END);
            isDrawerOpen = false;
            return;
        }
    }
}

