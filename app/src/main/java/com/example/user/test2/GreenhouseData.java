package com.example.user.test2;

public class GreenhouseData {

    private int temp;
    private String Name;
    private int pump;

    public GreenhouseData(){

    }

    public GreenhouseData(String Name, int temp, int pump){
        this.Name = Name;
        this.temp = temp;
        this.pump = pump;
    }

    public String getName(){
        return Name;
    }
    public int getTemp(){
        return temp;
    }
    public int getPump(){
        return pump;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setPump(int pump) {
        this.pump = pump;
    }
}
