package com.beehome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.beehome.datacollector.DataCollector;
import com.beehome.datacollector.DataCollectorEmulator;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataRefresher dataRefresher = new DataRefresher(findViewById(R.id.tempText), findViewById(R.id.humidText));
        DataCollector collector = new DataCollectorEmulator();
        Thread updateThread = new UpdateInfoThread(collector, dataRefresher);
        updateThread.start();
    }

    public void onRefresh(android.view.View view){
        refresh();
    }

    public void refresh() {
//        TextView tempText = findViewById(R.id.tempText);
//        TextView humidText = findViewById(R.id.humidText);
//        TextView batText = findViewById(R.id.batText);
//        int randTemp = Integer.parseInt(Long.toString(Math.round(Math.random() * 40)));
//        int randHun = Integer.parseInt(Long.toString(Math.round(Math.random() * 100)));
//        int randHun2 = Integer.parseInt(Long.toString(Math.round(Math.random() * 100)));
//        String tTxt = "Temperature: ";
//        String hTxt = "Humidity: ";
//        String bTxt = "Battery: ";
//        tempText.setText(tTxt + randTemp);
//        humidText.setText(hTxt + randHun);
//        batText.setText(bTxt + randHun2);
    }



//    public static void wait(int ms)
//    {
//        try
//        {
//            Thread.sleep(ms);
//        }
//        catch(InterruptedException ex)
//        {
//            Thread.currentThread().interrupt();
//        }
//    }

}