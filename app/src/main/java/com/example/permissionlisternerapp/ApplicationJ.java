package com.example.permissionlisternerapp;

import android.app.Application;
import android.content.ComponentName;
import android.content.pm.PackageManager;

import com.example.permissionlisternerapp.database.AppDatabase;

public class ApplicationJ extends Application {

    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db=AppDatabase.getAppDatabase(this);

        /*PackageManager pm = getApplicationContext().getPackageManager();
        ComponentName componentName = new ComponentName(this, com.example.permissionlisternerapp.ApplicationJ.class);
        pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);*/

        /*PackageManager pm = getApplicationContext().getPackageManager();
        ComponentName componentName = new ComponentName(this, com.example.permissionlisternerapp.ApplicationJ.class);
        pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);*/
    }
}
