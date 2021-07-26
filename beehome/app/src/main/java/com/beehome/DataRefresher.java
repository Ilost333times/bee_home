package com.beehome;

import android.widget.TextView;
import android.widget.ProgressBar;

public class DataRefresher {

    private TextView temperatureTextView;
    private TextView humidityTextView;
    private TextView batteryTextView;
    private ProgressBar tempLevel;
    private ProgressBar batteryLevel;

    public DataRefresher(TextView temperatureTextView2, TextView humidityTextView2, TextView batteryTextView2,
                         ProgressBar tempBar,ProgressBar batteryBar) {
        this.temperatureTextView = temperatureTextView2;
        this.humidityTextView = humidityTextView2;
        this.batteryTextView = batteryTextView2;
        this.tempLevel = tempBar;
        this.batteryLevel = batteryBar;
    }

    public void refresh(int temperature, int humidity, int battery, int x) {
        this.temperatureTextView.setText("Temperature: " + String.valueOf(temperature));
        this.humidityTextView.setText("Humidity: " + String.valueOf(humidity));
        this.batteryTextView.setText("Battery: " + String.valueOf(battery));
        this.tempLevel.setProgress(temperature + 50);
        this.batteryLevel.setProgress(battery);

    }
}
