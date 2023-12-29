package com.example.loopermessagequeuehandler;

import static com.example.loopermessagequeuehandler.MessageHandler.TASK_A;
import static com.example.loopermessagequeuehandler.MessageHandler.TASK_B;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LooperThread looperThread = new LooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View v) {
        looperThread.start();
    }

    public void stopThread(View v) {
        looperThread.looper.quit();
    }

    public void taskA(View v) {
        // Directly send a message to the thread messageQueue
        Message msg = Message.obtain();
        msg.what = TASK_A;
        looperThread.handler.sendMessage(msg);

        /*
        Handler threadHandler = new Handler(looperThread.looper);
        threadHandler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "run: " + i);
                    SystemClock.sleep(1000);
                }
            }
        });
        */
    }

    public void taskB(View v) {
        // Directly send a message to the thread messageQueue
        Message msg = Message.obtain();
        msg.what = TASK_B;
        looperThread.handler.sendMessage(msg);
    }
}