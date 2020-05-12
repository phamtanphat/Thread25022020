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
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                printFor("A");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                printFor("B");
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                printFor("C");
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
    // Cach 1 : Dong bo thread theo ham
    // Note : deadlock : xay ra khi nhiu thread
    // cung thuc thi 1 cong viec ma khong duoc dong bo
    public void printFor(String name){
        for (int i = 1 ; i <= 1000 ; i++){
            Log.d("BBB",name + " running at position: " + i);
        }
    }
}
