package com.example.user.test2;

import android.app.Activity;

public class CardZone {

    String Name;
    String Lack;

    public CardZone(String Name, String Lack){
        this.Name = Name;
        this.Lack = Lack;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLack() {
        return Lack;
    }

    public void setLack(String lack) {
        Lack = lack;
    }
}
