package com.abhiroop.multiplenavigation.fragment.tournament;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.activity.CreateTeamActivity;
import com.abhiroop.multiplenavigation.activity.MainActivity;
import com.abhiroop.multiplenavigation.fragment.createteam.AllRounderFragment;
import com.abhiroop.multiplenavigation.fragment.createteam.BatsmanFragment;
import com.abhiroop.multiplenavigation.fragment.createteam.BowlerFragment;
import com.abhiroop.multiplenavigation.fragment.createteam.WicketKeeperFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TournamentsFragments extends Fragment {

    private TournamentsViewModel mViewModel;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public static TournamentsFragments newInstance() {
        return new TournamentsFragments();
    }

    private TournamentsFragments tournamentsFragments;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(TournamentsViewModel.class);
        View root = inflater.inflate(R.layout.tournaments_fragment, container, false);
        /*final TextView textView = root.findViewById(R.id.tv);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        setUpViewPager(root);
        return root;
    }

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity());
        return adapter;
    }

    private void setUpViewPager(View root) {
        viewPager = (ViewPager2)root.findViewById(R.id.pager);
        tabLayout = root.findViewById(R.id.tab_layout);
        createCardAdapter();
        viewPager.setAdapter(createCardAdapter());
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(R.string.upcoming);
                        break;
                    case 1:
                        tab.setText(R.string.live);
                        break;
                    case 2:
                        tab.setText(R.string.past);
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }

    public class ViewPagerAdapter extends FragmentStateAdapter {

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment;
            switch (position){
                case 0:
                    fragment = new UpcomingFragment();
                    return fragment;
                case 1:
                    fragment = new LiveFragment();
                    return fragment;
                case 2:
                    fragment = new PastFragment();
                    return fragment;

            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TournamentsViewModel.class);
        // TODO: Use the ViewModel
    }

}