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
        String message = getName() + " is killing her presentation. Clapping is probably in order.";
        alerts.add(new Alert("Presentation Alert", "8015896710", false, "", message, false, true));
    }
}
