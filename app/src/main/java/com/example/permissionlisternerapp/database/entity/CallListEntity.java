package com.example.permissionlisternerapp.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "callListEntity")
public class CallListEntity{

    @ColumnInfo(name = "uniqueId")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int uniqueId;

    @ColumnInfo(name = "state")
    @SerializedName("state")
    private String state;

    @ColumnInfo(name = "number")
    @SerializedName("number")
    private String number;

    @ColumnInfo(name = "startTime")
    @SerializedName("start_time")
    private String startTime;

    @ColumnInfo(name = "endTime")
    @SerializedName("end_time")
    private String endTime;

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
