package com.example.sarah.silentalarm.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Alert implements Serializable {
    private String name;
    private ArrayList<String> contacts; //string of phone numbers. TODO should be map of names to phonenumbers
    private Boolean authorities; //false
    private String word; //TODO make snowboy.audio
    private String message;
    private Boolean sendLoc;
    //locations[]
    //times[]
    private String days;
    private String times;
    private Boolean alwaysOn; //true
    private Boolean enabled; //tur

    public Alert(){
        name = "";
        contacts = new ArrayList<>();
        authorities = false;
        word = "";
        message = User.get().getName() + " has sounded an alert via ALARMED. Please ensure they are safe.";
        sendLoc = false;
        alwaysOn = true;
        enabled = true;
        days = "MTWThF";
        times = "All Day";
    }

    public Alert(String name, String contact, Boolean authorities, String word, String message,
                 Boolean sendLoc, Boolean alwaysOn, String days, String times){
        this.name = name;
        this.contacts = new ArrayList<>();
        this.contacts.add(contact);
        this.authorities = authorities;
        this.word = word;
        this.message = message;
        this.sendLoc = sendLoc;
        this.alwaysOn = alwaysOn;
        this.enabled = true;
        this.days = days;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getContacts() {
        return contacts;
    }

    public String getContactString(){
        String allContacts = "";
        for(String name : contacts){
            allContacts += name + " ";
        }
        return  allContacts;
    }

    public void setContacts(ArrayList<String> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String contact){
        this.contacts.add(contact);
    }

    public Boolean getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Boolean authorities) {
        this.authorities = authorities;
    }

    //locations

    //times

    public Boolean getAlwaysOn() {
        return alwaysOn;
    }

    public void setAlwaysOn(Boolean alwaysOn) {
        this.alwaysOn = alwaysOn;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    //word

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSendLoc() {
        return sendLoc;
    }

    public void setSendLoc(Boolean sendLoc) {
        this.sendLoc = sendLoc;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
