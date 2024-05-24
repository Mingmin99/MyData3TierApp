package com.example.mydata.dao;


import com.example.mydata.dto.Asset;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetsMapper {
    List<Asset> getAssetsByUserId(String userid);
}
