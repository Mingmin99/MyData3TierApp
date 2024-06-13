package com.example.mydata.dto;


import java.sql.Timestamp;

public class Asset {
    private int id;
    private String userid;
    private String assetName;
    private int assetValue;
    private String assetType;
    private Timestamp createdAt;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public int getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(int assetValue) {
        this.assetValue = assetValue;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
