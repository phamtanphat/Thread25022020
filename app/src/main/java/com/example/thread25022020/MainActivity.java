package com.example.thread25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khoi tao ra luong
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB","Hello main");
            }
        });
        thread.start();
        CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Log.d("BBB",thread.getState().name());
            }
        };
        countDownTimer.start();

    }
}
