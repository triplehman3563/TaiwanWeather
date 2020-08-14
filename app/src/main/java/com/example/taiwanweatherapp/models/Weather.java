package com.example.taiwanweatherapp.models;

import java.util.List;

public class Weather {
    private List<String[]> Weather;
    private String title;

    private String[] Location;
    private String[] StartTime;
    private String[] EndTime;
    private String[] Wx;
    private String[] Pop;
    private String[] Cl;
    private String[] MinT;
    private String[] MaxT;

    public Weather(String[] Location, String[] StartTime, String[] EndTime, String[] Wx,
                   String[] Pop, String[] Cl, String[] MinT, String[] MaxT) {
        this.Location = Location;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Wx = Wx;
        this.Pop = Pop;
        this.Cl = Cl;
        this.MinT = MinT;
        this.MaxT = MaxT;
        Weather.add(Location);
        Weather.add(StartTime);
        Weather.add(EndTime);
        Weather.add(Wx);
        Weather.add(Pop);
        Weather.add(Cl);
        Weather.add(MinT);
        Weather.add(MaxT);

    }

    public List<String[]> getWeatherData() {
        return this.Weather;
    }

    public void setWeatherData(List<String[]> list) {
        this.Weather = list;

    }
}
