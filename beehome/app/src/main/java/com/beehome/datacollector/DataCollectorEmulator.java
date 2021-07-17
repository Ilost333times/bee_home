package com.beehome.datacollector;

public class DataCollectorEmulator implements DataCollector {

    public DataCollectorEmulator(){
    }

    @Override
    public int getTemperature() {
        return Integer.parseInt(Long.toString(Math.round(Math.random() * 40)));
    }

    @Override
    public int getHumidity() {
        return Integer.parseInt(Long.toString(Math.round(Math.random() * 100)));
    }

    @Override
    public int getBatteryLevel() {
        return Integer.parseInt(Long.toString(Math.round(Math.random() * 100)));
    }
}
