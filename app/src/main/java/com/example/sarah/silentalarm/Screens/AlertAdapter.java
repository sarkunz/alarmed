package com.example.sarah.silentalarm.Screens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.sarah.silentalarm.Models.Alert;
import com.example.sarah.silentalarm.R;
import com.example.sarah.silentalarm.Utils.SMS;

import java.util.ArrayList;

//TODO: set click listener on whole view
class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    ArrayList<Alert> alertList;

    public AlertAdapter(ArrayList<Alert> alertList){
        this.alertList = alertList;
    }

    @Override
    public AlertAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context c = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(c);
        View gameView = inflater.inflate(R.layout.alert_recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(gameView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlertAdapter.ViewHolder viewHolder, int position) {

        Alert alert = alertList.get(position);
        viewHolder.alertName.setText(alert.getName());
        //viewHolder.alertsWho.setText(alert.getContacts());
        //viewHolder.alertWord.setText(alert.getWord());
        //viewHolder.whenListening.setText(alert.getWhen());
    }

    @Override
    public int getItemCount() {
        return alertList.size() ;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView alertName;
        public TextView alertsWho;
        public TextView alertWord;
        public TextView whenListening;
        public Switch alertToggle;


        public ViewHolder(final View view) {
            super(view);

            alertName = (TextView) view.findViewById(R.id.alertName);
            alertsWho = (TextView) view.findViewById(R.id.alertsWho);
            alertWord = (TextView) view.findViewById(R.id.alertWord);
            whenListening = (TextView) view.findViewById(R.id.whenListening);
            alertToggle = (Switch) view.findViewById(R.id.alertToggle);
            alertToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        System.out.println("set enabled true");
                        //TODO: get this alert and set enabled to true
                    } else {
                        //get this alert and set enabled to false
                    }
                }
            });
            //Todo: switch to next activity when whole thing is clicked

        }
    }
}
