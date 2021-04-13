package com.abhiroop.multiplenavigation.fragment.tournament;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhiroop.multiplenavigation.R;

public class TournamentsFragments extends Fragment {

    private TournamentsViewModel mViewModel;

    public static TournamentsFragments newInstance() {
        return new TournamentsFragments();
    }

    private TournamentsFragments tournamentsFragments;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(TournamentsViewModel.class);
        View root = inflater.inflate(R.layout.settings_fragment, container, false);
        final TextView textView = root.findViewById(R.id.tv);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TournamentsViewModel.class);
        // TODO: Use the ViewModel
    }

}