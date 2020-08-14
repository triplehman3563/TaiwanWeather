package com.example.taiwanweatherapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taiwanweatherapp.models.Weather;

import java.util.List;

public class Fragment_Home_ViewModel extends ViewModel {
     private MutableLiveData<List<Weather>> mWeather;
     public LiveData<List<Weather>> getWeather(){

         return mWeather;
     }
}
