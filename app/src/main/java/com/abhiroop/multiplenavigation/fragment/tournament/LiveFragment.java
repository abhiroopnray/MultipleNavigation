package com.abhiroop.multiplenavigation.fragment.tournament;

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
import com.abhiroop.multiplenavigation.adapter.LiveFragmentAdapter;
import com.abhiroop.multiplenavigation.adapter.UpComingFragmentAdapter;

public class LiveFragment extends Fragment {

    private RecyclerView recyclerView;
    private LiveFragmentAdapter adapter;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    private LiveViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.live_fragment, container, false);
        initView(view);
        return view;
    }
    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();
        adapter = new LiveFragmentAdapter(getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter != null){
            adapter.startAnimation();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LiveViewModel.class);
        // TODO: Use the ViewModel
    }

}