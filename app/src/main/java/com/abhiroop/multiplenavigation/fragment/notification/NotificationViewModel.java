package com.abhiroop.multiplenavigation.fragment.notification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is NotificationViewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}