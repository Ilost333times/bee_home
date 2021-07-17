package com.beehome;

import android.widget.TextView;
import android.widget.ProgressBar;

public class DataRefresher {
    private TextView temperatureTextView;
    private TextView humidityTextView;
    private ProgressBar batteryLevel;

    public DataRefresher(TextView temperatureTextView2, TextView humidityTextView2, ProgressBar batteryTextView2) {
        this.temperatureTextView = temperatureTextView2;
        this.humidityTextView = humidityTextView2;
        this.batteryLevel = batteryTextView2;
    }

    public void refresh(int temperature, int humidity, int battery, int x) {
        this.temperatureTextView.setText("Temperature: " + String.valueOf(temperature));
        this.humidityTextView.setText("Humidity: " + String.valueOf(humidity));

        this.batteryLevel.setProgress(battery-x);

    }
}
