package com.example.sarah.silentalarm.Models;

import java.util.ArrayList;

//Singleton bc rn we only support 1 user :)
public class User {
    private ArrayList<Alert> alerts;
    //currentLocation **Holding off until I get voice set up
    private String name;
    //contacts[]
    //phone info? For texting?
    private static User instance;

    private User(){
        name = "Sarah Kunzler";
        alerts = new ArrayList<>();
        setHardCodedAlerts();
    }

    public static User get(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    public ArrayList<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(ArrayList<Alert> alerts) {
        this.alerts = alerts;
    }

    public void addAlert(Alert alert){
        alerts.add(alert);
    }

    public void removeAlert(Alert alert){
        alerts.remove(alert);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHardCodedAlerts(){
        String message = getName() + " has sounded an alert via ALARMED. Please ensure they are safe.";
        alerts.add(new Alert("Sarah's Alert", "(555)543-2100, (555)987-6543 ", false, "'Train'", message,
                false, true, "MTWThF", "5:00-5:30PM"));
        message = "this is a message.";
        alerts.add(new Alert("Scary Alert", "Authorities", true, "Shake", message,
                true, true, "MWF", "9:00-10:00PM"));
    }
}
