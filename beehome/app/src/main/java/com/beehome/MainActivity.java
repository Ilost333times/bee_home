package com.beehome;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import com.beehome.datacollector.DataCollector;
import com.beehome.datacollector.DataCollectorEmulator;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private UpdateInfoThread updateThread = null;
    private SwitchPlug switchPlug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }
        DataRefresher dataRefresher = new DataRefresher(findViewById(R.id.tempText), findViewById(R.id.humidText),
                findViewById(R.id.batText), findViewById(R.id.tempLevel), findViewById(R.id.batLevel));

        DataCollector collector = new DataCollectorEmulator();
        updateThread = new UpdateInfoThread(collector, dataRefresher);
        switchPlug = new SwitchPlug();

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.tempLevel);
        Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        progressBar.setProgressDrawable(progressDrawable);
        //progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));

        final Button onbutton = findViewById(R.id.onbutton);
        onbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                try {
                    switchPlug.TurnOn();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final Button offbutton = findViewById(R.id.offbutton);
        offbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                try {
                    switchPlug.TurnOff();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateThread.setIsToUpdate(true);
        updateThread.start();
    }


    protected void onStop(){
        super.onStop();
        updateThread.setIsToUpdate(false);
    }

    public void onRefresh(View view) {
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


}