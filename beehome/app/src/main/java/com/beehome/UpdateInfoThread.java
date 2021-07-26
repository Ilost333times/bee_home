package com.beehome;

import com.beehome.datacollector.DataCollector;
import com.beehome.datacollector.DataCollectorEmulator;
//import org.w3c.dom.CDATASection;

public class UpdateInfoThread extends Thread {

    private DataCollector dataCollector;
    private DataRefresher dataRefresher;
    private boolean isToUpdate = false;

    public UpdateInfoThread(DataCollector collector, DataRefresher dataRefresher) {
        this.dataCollector = collector;
        this.dataRefresher = dataRefresher;
        this.isToUpdate = true;
    }

    public void setIsToUpdate(boolean is) {
        this.isToUpdate = is;
    }

    public void run() {
        int x = 0;
        while (this.isToUpdate) {
            try {
                //wait for 3 sec
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {
                System.err.println("Update thread failed:" + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("Update Temperature!!!!!");
            int temp = this.dataCollector.getTemperature();
            int humidity = this.dataCollector.getHumidity();
            int battery = dataCollector.getBatteryLevel();
            dataRefresher.refresh(temp, humidity, battery, x);
            x++;
        }
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
                System.out.println("This code is running  in a thread");
            }
        };
        t.scheduleAtFixedRate(tt,500,1500);
    }
    */
}
