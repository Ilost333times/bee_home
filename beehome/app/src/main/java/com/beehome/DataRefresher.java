package com.beehome;

import android.widget.TextView;

public class DataRefresher {
    private TextView temperatureTextView;
    private TextView humidityTextView;
    private TextView batteryTextView;

    public DataRefresher(TextView temperatureTextView2, TextView humidityTextView2, TextView batteryTextView2) {
        this.temperatureTextView = temperatureTextView2;
        this.humidityTextView = humidityTextView2;
        this.batteryTextView = batteryTextView2;
    }

    public void refresh(int temperature, int humidity, int battery) {
        this.temperatureTextView.setText("Temperature: " + String.valueOf(temperature));
        this.humidityTextView.setText("Humidity: " + String.valueOf(humidity));
        this.batteryTextView.setText("Battery: " + String.valueOf(battery));
    }
}
