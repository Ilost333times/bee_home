package com.beehome;

import com.beehome.datacollector.DataCollector;
import com.beehome.datacollector.DataCollectorEmulator;

import java.util.Timer;
import java.util.TimerTask;
//import org.w3c.dom.CDATASection;

public class UpdateInfoThread extends Thread {

    private DataCollector dataCollector;
    private DataRefresher dataRefresher;

    public UpdateInfoThread(DataCollector collector, DataRefresher dataRefresher) {
        this.dataCollector = dataCollector;
        this.dataRefresher = dataRefresher;
    }
    /*
    public void main(String[] args) {
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hi");
                int temp = this.dataCollector.getTemperature();
                int humidity = this.dataCollector.getHumidity();
                dataRefresher.refresh(temp, humidity);
                System.out.println("This code is running in a thread");
            }
        };
        t.scheduleAtFixedRate(tt,500,1500);
    }
    */
}
