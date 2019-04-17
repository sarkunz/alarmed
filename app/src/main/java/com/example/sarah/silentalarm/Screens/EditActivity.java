package com.example.sarah.silentalarm.Screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.example.sarah.silentalarm.Models.Alert;
import com.example.sarah.silentalarm.Models.User;
import com.example.sarah.silentalarm.R;

public class EditActivity extends AppCompatActivity {
    EditText nameBox;
    EditText wordBox;
    CheckBox authoritiesCheck;
    CheckBox contactsCheck;
    EditText messageBox;
    Switch sendLocSwitch;
    CheckBox customLocCheck;
    CheckBox timeCheck;
    CheckBox alwaysCheck;
    User model;
    Alert alert;

    public EditActivity(){
        model = User.get();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set alert from bundle
        setContentView(R.layout.edit_activity);
        getVars();
        alert = (Alert) getIntent().getSerializableExtra("Alert");
        fillInfo();
        setListeners();
    }

    private void getVars(){
        nameBox = (EditText) findViewById(R.id.editName);
        wordBox = (EditText) findViewById(R.id.editAlertWord);
//        authoritiesCheck = (CheckBox) findViewById(R.id.authoritiesCheck);
//        contactsCheck = (CheckBox) findViewById(R.id.contactsCheck);
        messageBox = (EditText) findViewById(R.id.editMessage);
        sendLocSwitch = (Switch) findViewById(R.id.sendLocSwitch);
        customLocCheck = (CheckBox) findViewById(R.id.customLocCheck);
        timeCheck = (CheckBox) findViewById(R.id.timeCheck);
        alwaysCheck = (CheckBox) findViewById(R.id.alwaysWatchingCheck);

        //submit and cancel buttons

    }

    private void fillInfo(){
        //name edit text
        nameBox.setText(alert.getName());
        wordBox.setText(alert.getWord());
        if(alert.getAuthorities()) authoritiesCheck.setChecked(true);
        if(alert.getContacts().size() > 0) contactsCheck.setChecked(true);
        messageBox.setText(alert.getMessage());
        if(alert.getSendLoc()) contactsCheck.setChecked(true);

        if(alert.getAlwaysOn()) alwaysCheck.setChecked(true);


        //listen when checkboxes
    }

    private void setListeners(){
        //name edit text
        //alert checkboxes
        //listen when checkboxes
    }

}
