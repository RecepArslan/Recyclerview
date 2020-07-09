package com.example.proje2_rcyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent = new Intent(this, homePageActivity.class);
        final Activity activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                activity.isDestroyed();
                startActivity(intent);
                finish();


            }

        };
        timer.schedule(task, 2000, 1000);
    }
}