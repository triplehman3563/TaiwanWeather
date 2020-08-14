package com.example.taiwanweatherapp.viewmodelfactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taiwanweatherapp.viewmodels.Fragment_Home_ViewModel;

public class  Fragment_Home_ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(Fragment_Home_ViewModel.class)) {
            return ;
        }
        return null;
    }
}
