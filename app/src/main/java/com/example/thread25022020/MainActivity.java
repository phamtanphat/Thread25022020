package com.example.thread25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int A,B,C;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khoi tao ra luong

//        Cach 2 : Dong bo thread theo object
//        A sinh ra 1 so index
//        B sinh ra 1 so index
//        C ket qua a +b
        A = B = C = 0;
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 10 ; i++){
                    A = i;
                    Log.d("BBB","A : " + i);
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 10 ; i++){
                    B = i;
                    Log.d("BBB","B : " + i);
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 10 ; i++){
                    C = A + B;
                    Log.d("BBB","C : " + C);
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }


}
