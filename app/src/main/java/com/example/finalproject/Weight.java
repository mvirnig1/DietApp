package com.example.finalproject;
import java.io.Serializable;

public class Weight implements Serializable{
    private long id;
    private String weightLoss;
    private String date;
    private String time;

Weight(long id, String weightLoss, String date, String time){
    this.id = id;
    this.weightLoss = weightLoss;
    this.date = date;
    this.time = time;
}
    Weight(){

 }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String getWeightLoss() {
        return weightLoss;
    }

    void setWeightLoss(String weightLoss) {
        this.weightLoss = weightLoss;
    }

    String getDate() {
        return date;
    }

    void setDate(String date) {
        this.date = date;
    }
    String getTime() {
        return time;
    }

    void setTime(String time) {
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
