package com.beehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import com.beehome.datacollector.DataCollector;
import com.beehome.datacollector.DataCollectorEmulator;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    private UpdateInfoThread updateThread = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataRefresher dataRefresher = new DataRefresher(findViewById(R.id.tempText), findViewById(R.id.humidText),
                findViewById(R.id.batText), findViewById(R.id.tempLevel), findViewById(R.id.batLevel));

        DataCollector collector = new DataCollectorEmulator();
        updateThread = new UpdateInfoThread(collector, dataRefresher);


        ProgressBar progressBar = (ProgressBar) findViewById(R.id.tempLevel);
        Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        progressBar.setProgressDrawable(progressDrawable);
        //progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
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