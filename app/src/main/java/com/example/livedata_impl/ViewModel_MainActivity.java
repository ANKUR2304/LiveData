package com.example.livedata_impl;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModel_MainActivity extends ViewModel {
    private int count = 0;

    private MutableLiveData<Integer> liveCount;

    public MutableLiveData<Integer> getInitialCount(){
        return liveCount;
    }

    public void getCount(){
        liveCount.setValue(count);
        return;
    }

    public void increaseCount(){
        count++;
        liveCount.setValue(count);
        return;
    }
}
