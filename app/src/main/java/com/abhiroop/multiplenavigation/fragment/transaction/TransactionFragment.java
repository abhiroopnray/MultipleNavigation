package com.abhiroop.multiplenavigation.fragment.transaction;

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

public class TransactionFragment extends Fragment {

    private TransactionViewModel mViewModel;
    private Context mContext;

    public TransactionFragment(Context mContext) {
        this.mContext = mContext;
    }

    public static TransactionFragment newInstance(Context context) {
        return new TransactionFragment(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((MainActivity)mContext).showHideAdBanner(false);

        return inflater.inflate(R.layout.transaction_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TransactionViewModel.class);
        // TODO: Use the ViewModel
    }

}