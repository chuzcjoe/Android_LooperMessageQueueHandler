package com.example.loopermessagequeuehandler;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class LooperThread extends Thread{
    private static final String TAG = "LooperThread";

    public Handler handler;

    public Looper looper;

    @Override
    public void run() {
        Looper.prepare();
        looper = Looper.myLooper();
        handler = new MessageHandler(); // associated with background thread
        Looper.loop();

        Log.d(TAG, "end of run()");
    }
}
