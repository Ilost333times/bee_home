package com.beehome;

import com.beehome.datacollector.DataCollector;

import org.w3c.dom.CDATASection;

public class UpdateInfoThread extends Thread{
    private DataCollector dataCollector;
    private DataRefresher dataRefresher;

    public UpdateInfoThread(DataCollector collector, DataRefresher dataRefresher) {
        this.dataCollector = collector;
        this.dataRefresher = dataRefresher;
    }

    public void run() {
        Double temp = this.dataCollector.getTemperature();
        Double humity = this.dataCollector.getHumidity();
        dataRefresher.refresh(temp,  humity);
        System.out.println("This code is running in a thread");
    }
}
