package com.example.mydata.dto;


import java.sql.Timestamp;

public class Asset {
    private int id;
    private String userid;
    private String assetName;
    private int assetValue;
    private String assetType;
    private Timestamp createdAt;

    // 기본 생성자
    public Asset() {
    }

    // 모든 필드를 포함하는 생성자
    public Asset(int id, String userid, String assetName, int assetValue, String assetType, Timestamp createdAt) {
        this.id = id;
        this.userid = userid;
        this.assetName = assetName;
        this.assetValue = assetValue;
        this.assetType = assetType;
        this.createdAt = createdAt;
    }

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
