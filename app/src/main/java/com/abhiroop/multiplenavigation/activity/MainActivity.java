package com.abhiroop.multiplenavigation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.fragment.about.AboutFragment;
import com.abhiroop.multiplenavigation.fragment.home.HomeFragment;
import com.abhiroop.multiplenavigation.fragment.mymatches.MyMatchesFragment;
import com.abhiroop.multiplenavigation.fragment.notification.NotificationFragment;
import com.abhiroop.multiplenavigation.fragment.records.RecordsFragment;
import com.abhiroop.multiplenavigation.fragment.settings.SettingsFragment;
import com.abhiroop.multiplenavigation.fragment.tournament.TournamentsFragments;
import com.abhiroop.multiplenavigation.fragment.transaction.TransactionFragment;
import com.abhiroop.multiplenavigation.fragment.wallet.WalletFragment;
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
                switch (id) {
                    case R.id.navigation_home:
                        loadFragment(MultipleNavigationConstants.HOME_FRAGMENT);
                        return true;
                    case R.id.navigation_tournaments:
                        loadFragment(MultipleNavigationConstants.TOURNAMENT_FRAGMENT);
                        return true;
                    case R.id.navigation_my_matches:
                        loadFragment(MultipleNavigationConstants.MY_MATCHES_FRAGMENTS);
                        return true;
                    case R.id.navigation_notification:
                        loadFragment(MultipleNavigationConstants.NOTIFICATION_FRAGMENTS);
                        return true;
                    case R.id.navigation_settings:
                        loadFragment(MultipleNavigationConstants.SETTINGS_FRAGMENTS);
                        return true;
                }
                return true;
            }
        });
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
                isDrawerOpen = true;
            }
        });
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
                        loadFragment(MultipleNavigationConstants.ABOUT_FRAGMENT);
                        closeDrawer();
                        return true;
                    case R.id.records:
                        loadFragment(MultipleNavigationConstants.RECORDS_FRAGMENT);
                        closeDrawer();
                        return true;
                    case R.id.wallet:
                        loadFragment(MultipleNavigationConstants.WALLET_FRAGMENT);
                        closeDrawer();
                        return true;
                    case R.id.transaction:
                        loadFragment(MultipleNavigationConstants.TOURNAMENT_FRAGMENT);
                        closeDrawer();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.RIGHT);
                isDrawerOpen = true;
                return true;
        }
        return true;
    }

    private void loadFragment(String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tag) {
            case MultipleNavigationConstants.HOME_FRAGMENT:
                fragmentTransaction.replace(R.id.frame, new HomeFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.MY_MATCHES_FRAGMENTS:
                fragmentTransaction.replace(R.id.frame, new MyMatchesFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.NOTIFICATION_FRAGMENTS:
                fragmentTransaction.replace(R.id.frame, new NotificationFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.SETTINGS_FRAGMENTS:
                fragmentTransaction.replace(R.id.frame, new SettingsFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.TOURNAMENT_FRAGMENT:
                fragmentTransaction.replace(R.id.frame, new TournamentsFragments(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.ABOUT_FRAGMENT:
                fragmentTransaction.replace(R.id.frame, new AboutFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.RECORDS_FRAGMENT:
                fragmentTransaction.replace(R.id.frame, new RecordsFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.WALLET_FRAGMENT:
                fragmentTransaction.replace(R.id.frame, new WalletFragment(), tag);
                fragmentTransaction.commit();
                break;
            case MultipleNavigationConstants.TRANSACTION_FRAGMENT:
                fragmentTransaction.replace(R.id.frame, new TransactionFragment(), tag);
                fragmentTransaction.commit();
                closeDrawer();
                break;
        }

    }

    private void closeDrawer() {
        if (isDrawerOpen)
            drawerLayout.closeDrawer(Gravity.LEFT);
        isDrawerOpen = false;
    }

    @Override
    public void onBackPressed() {
        if (isDrawerOpen) {
            closeDrawer();
            return;
        }
    }
}

