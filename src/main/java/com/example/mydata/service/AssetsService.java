package com.example.mydata.service;

import com.example.mydata.dto.Asset;

import java.util.List;

public interface AssetsService {
    public List<Asset> getAssetsByUserId(String userid);
}
