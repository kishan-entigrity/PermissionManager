package com.example.permissionlisternerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.permissionlisternerapp.Listing.CallListing;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtA, txtB, txtC;
    private String strPassAns = "";
    private String strDefaultPass = "ACBA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtA = (TextView) findViewById(R.id.txtA);
        txtB = (TextView) findViewById(R.id.txtB);
        txtC = (TextView) findViewById(R.id.txtC);

        txtA.setOnClickListener(this);
        txtB.setOnClickListener(this);
        txtC.setOnClickListener(this);

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
//                Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
//                .setRationaleTitle("This is first permission sample")
//                .setRationaleMessage("Message for the permission should be mentioned here, like what is accept and what if don't")
                .setDeniedTitle("Permission denied")
                .setDeniedMessage("Message for teh permission denied should be mention here")
                .setGotoSettingButtonText("go to settings")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.PROCESS_OUTGOING_CALLS)
                .check();

        /*String phone=getIntent().getStringExtra("extra_phone");
        if(!phone.equals(null)){
            Toast.makeText(getBaseContext(), phone, Toast.LENGTH_LONG).show();
        }*/

        /*PackageManager pm = getApplicationContext().getPackageManager();
        ComponentName componentName = new ComponentName(this, com.example.permissionlisternerapp.MainActivity.class);
        pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtA:
                strPassAns = strPassAns+"A";
                checkPassword();
                break;

            case R.id.txtB:
                strPassAns = strPassAns+"B";
                checkPassword();
                break;

            case R.id.txtC:
                strPassAns = strPassAns+"C";
                checkPassword();
                break;
        }
    }

    private void checkPassword() {

        Log.e("*+*+*","strPassAns : "+strPassAns);
        Log.e("*+*+*","strPassAns Lenght : "+strPassAns.length());
        if(strPassAns.length()==4) {
            if(strDefaultPass.equalsIgnoreCase(strPassAns)) {
                Toast.makeText(this, "Password applied successfully..", Toast.LENGTH_SHORT).show();
                strPassAns = "";
                Intent intent = new Intent(MainActivity.this, CallListing.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Oops wrong pass..", Toast.LENGTH_SHORT).show();
                strPassAns = "";
            }
        }

    }
}
