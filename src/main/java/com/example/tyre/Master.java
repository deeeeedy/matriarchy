package com.example.tyre;

public class Master {
    String Master;
    String Monday, Tuesday,Wednesday,Thursday, Friday, Saturday, Sunday;
    public Master(String Master, String Monday, String Tuesday, String Wednesday, String Thursday,String Friday, String Saturday, String Sunday){
        this.Master = Master;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
        this.Sunday = Sunday;
    }
    public void setMaster(String Master){
        this.Master = Master;
    }
    public void setMonday(String Monday){
        this.Monday = Monday;
    }
    public void setTuesday(String Tuesday){
        this.Tuesday = Tuesday;
    }
    public void setWednesday(String Wednesday){
        this.Wednesday = Wednesday;
    }
    public void setThursday(String Thursday){
        this.Thursday = Thursday;
    }
    public void setFriday(String Friday){
        this.Friday = Friday;
    }
    public void setSaturday(String Saturday){
        this.Saturday = Saturday;
    }
    public void setSunday(String Sunday){
        this.Sunday = Sunday;
    }

    public String getMaster(){
        return Master;
    }
    public String getMonday(){
        return Monday;
    }
    public String getTuesday(){
        return Tuesday;
    }
    public String getWednesday(){
        return  Wednesday;
    }
    public String getThursday(){
        return Thursday;
    }
    public String getFriday(){
        return  Friday;
    }
    public String getSaturday(){
        return Saturday;
    }
    public String getSunday(){
        return Sunday;
    }
}
