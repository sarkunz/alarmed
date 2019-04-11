package com.example.sarah.silentalarm.Screens;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sarah.silentalarm.Models.User;
import com.example.sarah.silentalarm.R;

public class LoginActivity extends AppCompatActivity {

    private String[] PERMISSIONS = {
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECORD_AUDIO,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.VIBRATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        checkPermissions();
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkPermissions(){
        // Here, thisActivity is the current activity
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.SEND_SMS)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Permission is not granted
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.SEND_SMS)) {
//                // Show an explanation to the user *asynchronously*
//            } else {
//                //Request the permission
//                ActivityCompat.requestPermissions(this,
//                        PERMISSIONS, 1);
//            }
//        } else {
//            // Permission has already been granted
//        }

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        }

    }

    public void switchToAlertsActivity(View view){
        User.get();
        Intent i = new Intent(this, AlertsActivity.class);
        startActivity(i);
    }
}
