package com.example.loopermessagequeuehandler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class MessageHandler extends Handler {
    private static final String TAG = "MessageHandler";

    public static final int TASK_A = 1;

    public static final int TASK_B = 2;

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what) {
            case TASK_A:
                Log.d(TAG, "TASK A executed");
                break;
            case TASK_B:
                Log.d(TAG, "TASK B executed");
                break;
        }
    }
}
