package com.beehome.datacollector;

public class DataCollectorEmulator implements DataCollector {

    public DataCollectorEmulator(){
    }

    @Override
    public Double getTemperature() {
        return Math.random();
    }

    @Override
    public Double getHumidity() {
        return Math.random();
    }
}
