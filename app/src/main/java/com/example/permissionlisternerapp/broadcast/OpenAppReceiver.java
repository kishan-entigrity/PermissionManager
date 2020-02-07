package com.example.permissionlisternerapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.permissionlisternerapp.Activity.Splash;
import com.example.permissionlisternerapp.MainActivity;

public class OpenAppReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNumber = getResultData();
        if (phoneNumber == null) {
            // No reformatted number, use the original
            phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        }

        if(phoneNumber.equals("#999")){ // DialedNumber checking.
            // My app will bring up, so cancel the broadcast
            setResultData(null);

            // Start my app
            Intent i=new Intent(context, Splash.class);
            i.putExtra("extra_phone", phoneNumber);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
