package com.smetutorials.weatherapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;

public class AutoStart extends BroadcastReceiver {

    public void onReceive(Context arg0, Intent arg1) {
        if(arg1.getAction().equals("android.intent.action.SCREEN_OFF")) {
            Intent localIntent = new Intent(arg0, MainActivity.class);
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.addFlags(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
            arg0.startActivity(localIntent);
        }
    }
}