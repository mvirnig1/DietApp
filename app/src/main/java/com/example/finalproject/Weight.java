package com.example.finalproject;
import java.io.Serializable;
import java.util.Date;

public class Weight implements Serializable{
    private long id;
private String weightLoss;
private String date;
private String time;

public Weight(long id, String weightLoss, String date, String time){
    this.id = id;
    this.weightLoss = weightLoss;
    this.date = date;
    this.time = time;
}
    public Weight(String weightLoss, String date, String time){
        this.weightLoss = weightLoss;
        this.date = date;
        this.time = time;
    }

    public Weight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(String weightLoss) {
        this.weightLoss = weightLoss;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String toString() {
        return "Weight{" +
                "weight='" + weightLoss + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
