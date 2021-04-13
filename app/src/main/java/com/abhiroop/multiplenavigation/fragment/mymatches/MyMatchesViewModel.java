package com.abhiroop.multiplenavigation.fragment.mymatches;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMatchesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyMatchesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MyMatchesViewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}