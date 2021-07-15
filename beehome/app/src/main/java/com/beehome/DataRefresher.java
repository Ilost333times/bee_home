package com.beehome;

import android.widget.TextView;

public class DataRefresher {
    private TextView temperatureTextView;
    private TextView humidityTextView;

    public DataRefresher(TextView temperatureTextView2, TextView humidityTextView2) {
        this.temperatureTextView = temperatureTextView2;
        this.humidityTextView = humidityTextView2;
    }

    public void refresh(Double temperature, Double humidity) {

        this.temperatureTextView.setText(temperature.toString());

    }


}
