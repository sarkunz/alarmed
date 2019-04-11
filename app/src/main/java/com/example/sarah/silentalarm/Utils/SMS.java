package com.example.sarah.silentalarm.Utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;

public class SMS extends Activity
{

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    //sends an SMS message to another device
    public void sendSMS(String phoneNumber, String message)
    {
        SmsManager smgr = SmsManager.getDefault();
        message += "\n\n Sent via ALARMED";
        smgr.sendTextMessage(phoneNumber,null,message,null,null);
    }
}