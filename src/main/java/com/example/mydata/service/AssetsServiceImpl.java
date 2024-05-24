package com.example.mydata.service;

import com.example.mydata.dao.AssetsMapper;
import com.example.mydata.dto.Asset;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssetsServiceImpl implements AssetsService {

    private final AssetsMapper mapper;

    public AssetsServiceImpl(AssetsMapper mapper) {
        this.mapper = mapper;
    }

    public List<Asset> getAssetsByUserId(String userid) {
        return mapper.getAssetsByUserId(userid);
    }
}
