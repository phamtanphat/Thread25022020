package com.example.thread25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int A,B,C;
    MyFlag myFlag;
    mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new mHandler();
        ThreadData threadData = new ThreadData();
        threadData.start();

    }

    class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case  0:
                    Toast.makeText(MainActivity.this, "Hello Main", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(MainActivity.this, msg.getData().get("obj").toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    class ThreadData extends Thread{
        @Override
        public void run() {
            super.run();
            mHandler.sendEmptyMessage(0);
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Message message = mHandler.obtainMessage(1,"Goodbye Main");
                    mHandler.sendMessage(message);
                }
            },2000);
        }
    }
}
