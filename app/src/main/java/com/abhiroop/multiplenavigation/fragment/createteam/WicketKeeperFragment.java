package com.abhiroop.multiplenavigation.fragment.createteam;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.adapter.BowlerFragmentAdapter;
import com.abhiroop.multiplenavigation.adapter.WicketKeeperFragmentAdapter;

public class WicketKeeperFragment extends Fragment {

    private WicketKeeperViewModel mViewModel;
    private RecyclerView recyclerView;

    public static WicketKeeperFragment newInstance() {
        return new WicketKeeperFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wicket_keeper_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.player_selection_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();
        WicketKeeperFragmentAdapter adapter = new WicketKeeperFragmentAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WicketKeeperViewModel.class);
        // TODO: Use the ViewModel
    }

}