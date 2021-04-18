package com.abhiroop.multiplenavigation.fragment.records;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.activity.MainActivity;

public class RecordsFragment extends Fragment {

    private RecordsViewModel mViewModel;
    private Context mContext;

    public RecordsFragment(int contentLayoutId, Context mContext) {
        super(contentLayoutId);
        this.mContext = mContext;
    }

    public RecordsFragment(Context mContext) {
        this.mContext = mContext;
    }

    public static RecordsFragment newInstance(Context context) {
        return new RecordsFragment(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((MainActivity)mContext).showHideAdBanner(false);
        return inflater.inflate(R.layout.records_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecordsViewModel.class);
        // TODO: Use the ViewModel
    }

}