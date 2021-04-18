package com.abhiroop.multiplenavigation.fragment.wallet;

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

public class WalletFragment extends Fragment {

    private WalletViewModel mViewModel;
    private Context mContext;

    public static WalletFragment newInstance(Context context) {
        return new WalletFragment(context);
    }

    public WalletFragment(/*WalletViewModel mViewModel,*/ Context mContext) {
        /*this.mViewModel = mViewModel;*/
        this.mContext = mContext;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ((MainActivity)mContext).showHideAdBanner(false);
        return inflater.inflate(R.layout.wallet_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WalletViewModel.class);
        // TODO: Use the ViewModel
    }

}