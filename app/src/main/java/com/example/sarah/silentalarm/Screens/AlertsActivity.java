package com.example.sarah.silentalarm.Screens;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sarah.silentalarm.Models.Alert;
import com.example.sarah.silentalarm.Models.User;
import com.example.sarah.silentalarm.R;
import com.example.sarah.silentalarm.Utils.SMS;
import com.example.sarah.silentalarm.Utils.ShakeDetector;


public class AlertsActivity extends AppCompatActivity {
    // Shake detection stuff
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private ShakeDetector shakeDetector;
    private SMS sms;
    //private RecordingThread recordingThread;
    private Boolean isDetectionOn;
    Vibrator v;
    User user;

    RecyclerView alertList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_activity);
        sms = new SMS();
        user = User.get();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        alertList = findViewById(R.id.alertList);
        alertList.setAdapter(new AlertAdapter(user.getAlerts()));
        alertList.setLayoutManager(new LinearLayoutManager(this));

        // ShakeDetector initialization
        initShake();

        //init hotword
        initHotword();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startRecording();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Register the Session Manager Listener onResume
        sensorManager.registerListener(shakeDetector, accelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Unregister the Sensor Manager onPause
        sensorManager.unregisterListener(shakeDetector);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopRecording();
    }

    ///////////////click listeners/////////////////////////
    public void addAlert(View view){ //clicked FAB
        Alert newAlert = new Alert();
        user.addAlert(newAlert);
        Intent i = new Intent(this, EditActivity.class);
        i.putExtra("Alert", newAlert);
        startActivity(i);
    }

    //////////////Shake listener stuff/////////////////////
    private void initShake(){
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        shakeDetector = new ShakeDetector();
        shakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                //DO SOMETHING
                System.out.println("IM SHOOK");
                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                //9703559960 Carter Sarah is currently rocking her presentation. Applause might be in order ;)
                sms.sendSMS("8015896710", "Sarah is currently rocking her presentation. Applause might be in order ;)");
            }
        });
    }

    ///////////////Hotword stuff///////////////////////////
    private void initHotword() {
//        isDetectionOn = false;
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this,
//                        Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
//            AppResCopy.copyResFromAssetsToSD(this);
//
//            recordingThread = new RecordingThread(new Handler() {
//                @Override
//                public void handleMessage(Message msg) {
//                    MsgEnum message = MsgEnum.getMsgEnum(msg.what);
//                    switch(message) {
//                        case MSG_ACTIVE:
//                            sms.sendSMS("8015896710", "Yes master?");
//                            break;
//                        case MSG_INFO:
//                            break;
//                        case MSG_VAD_SPEECH:
//                            break;
//                        case MSG_VAD_NOSPEECH:
//                            break;
//                        case MSG_ERROR:
//                            break;
//                        default:
//                            super.handleMessage(msg);
//                            break;
//                    }
//                }
//            }, new AudioDataSaver());
//        }
    }

    private void startRecording(){
//        if(recordingThread !=null && !isDetectionOn) {
//            recordingThread.startRecording();
//            isDetectionOn = true;
//        }
    }

    private void stopRecording(){
//        if(recordingThread !=null && isDetectionOn){
//            recordingThread.stopRecording();
//            isDetectionOn = false;
//        }
    }

}
