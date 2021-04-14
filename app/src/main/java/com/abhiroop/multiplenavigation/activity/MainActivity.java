package com.abhiroop.multiplenavigation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.adapter.BannerAdapter;
import com.abhiroop.multiplenavigation.fragment.MyProfileFragment;
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

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean isDrawerOpen;
    private FragmentManager fragmentManager;
    private RelativeLayout bannerLayout;
    private BannerAdapter bannerAdapter;
    private RecyclerView recyclerView;
    private final static int BANNER_SCROLL_TIME = 2000;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setUpNavigationDrawer();
        setUpBottomNavigationBar();
        fragmentManager = getSupportFragmentManager();
        loadFragment(MultipleNavigationConstants.HOME_FRAGMENT);
        setUpBanner();
    }

    private void setUpBanner() {
        bannerLayout = findViewById(R.id.banner_layout);
        recyclerView = bannerLayout.findViewById(R.id.recyclerview_banner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                super.smoothScrollToPosition(recyclerView, state, position);
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        bannerAdapter = new BannerAdapter();
        recyclerView.setAdapter(bannerAdapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        //snapHelper.attachToRecyclerView(recyclerView);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                initiateAutoScroll();
            }
        }, 2000, 2000);
    }

    private void initiateAutoScroll() {
        if (count >= bannerAdapter.getItemCount()) {
            recyclerView.smoothScrollToPosition(0);
            count = 0;
        }
        recyclerView.smoothScrollToPosition(++count);
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
                        showHideAdBanner(true);
                        return true;
                    case R.id.navigation_tournaments:
                        loadFragment(MultipleNavigationConstants.TOURNAMENT_FRAGMENT);
                        showHideAdBanner(false);
                        return true;
                    case R.id.navigation_my_matches:
                        loadFragment(MultipleNavigationConstants.MY_MATCHES_FRAGMENTS);
                        showHideAdBanner(false);
                        return true;
                    case R.id.navigation_notification:
                        loadFragment(MultipleNavigationConstants.NOTIFICATION_FRAGMENTS);
                        showHideAdBanner(false);
                        return true;
                    case R.id.navigation_settings:
                        loadFragment(MultipleNavigationConstants.SETTINGS_FRAGMENTS);
                        showHideAdBanner(false);
                        return true;
                }
                return true;
            }
        });
    }

    public void showHideAdBanner(boolean state){
        if(state){
            bannerLayout.setVisibility(View.VISIBLE);
        }else{
            bannerLayout.setVisibility(View.GONE);
        }

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    private void setUpNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.profile:
                        Intent intent = new Intent(MainActivity.this, MyProfile.class);
                        startActivity(intent);
                        closeDrawer();
                        return true;
                    case R.id.about:
                        loadFragment(MultipleNavigationConstants.ABOUT_FRAGMENT);
                        showHideAdBanner(false);
                        closeDrawer();
                        return true;
                    case R.id.records:
                        loadFragment(MultipleNavigationConstants.RECORDS_FRAGMENT);
                        showHideAdBanner(false);
                        closeDrawer();
                        return true;
                    case R.id.wallet:
                        loadFragment(MultipleNavigationConstants.WALLET_FRAGMENT);
                        showHideAdBanner(false);
                        closeDrawer();
                        return true;
                    case R.id.transaction:
                        loadFragment(MultipleNavigationConstants.TOURNAMENT_FRAGMENT);
                        showHideAdBanner(false);
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
            case R.id.option_wallet:
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, new WalletFragment(), MultipleNavigationConstants.WALLET_FRAGMENT);
                fragmentManager.beginTransaction().commit();
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
            case MultipleNavigationConstants.MY_PROFILE:
                fragmentTransaction.replace(R.id.frame, new MyProfileFragment(), tag);
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

