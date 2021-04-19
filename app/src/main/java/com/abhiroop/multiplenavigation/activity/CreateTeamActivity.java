package com.abhiroop.multiplenavigation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.fragment.createteam.AllRounderFragment;
import com.abhiroop.multiplenavigation.fragment.createteam.BatsmanFragment;
import com.abhiroop.multiplenavigation.fragment.createteam.BowlerFragment;
import com.abhiroop.multiplenavigation.fragment.createteam.WicketKeeperFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CreateTeamActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    /*private int[] tabIcons = {
            R.drawable.ic_wicket_keeper,
            R.drawable.ic_batsman,
            R.drawable.ic_all_rounder,
            R.drawable.ic_bowler};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        setUpToolBar();
        setUpViewPager();
    }

    private void setUpViewPager() {
        viewPager = (ViewPager2) findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);
        createCardAdapter();
        viewPager.setAdapter(createCardAdapter());
        viewPager.setOffscreenPageLimit(4);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setIcon(R.drawable.ic_wicket_keeper);
                        tab.setText(R.string.wicket_keeper);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_batsman);
                        tab.setText(R.string.batsman);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_all_rounder);
                        tab.setText(R.string.all_rounder);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_bowler);
                        tab.setText(R.string.bowler);
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        return adapter;
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class ViewPagerAdapter extends FragmentStateAdapter{

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment;
            switch (position){
                case 0:
                    fragment = new WicketKeeperFragment();
                    return fragment;
                case 1:
                    fragment = new BatsmanFragment();
                    return fragment;
                case 2:
                    fragment = new AllRounderFragment();
                    return fragment;
                case 3:
                    fragment = new BowlerFragment();
                    return fragment;
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
}