package com.example.mydata.service;

import com.example.mydata.dao.ProfileMapper;
import com.example.mydata.dto.Asset;
import com.example.mydata.dto.LoanCondition;
import com.example.mydata.dto.Notice;
import com.example.mydata.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileMapper mapper;

    public ProfileServiceImpl(ProfileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User getUserById(String userId) {
        return mapper.getUserById(userId);
    }

    @Override
    public List<Asset> getAssetsByUserId(String userId) {
        return mapper.getAssetsByUserId(userId);
    }

    @Override
    public List<LoanCondition> getLoansByUserId(String userId) {
        return mapper.getLoansByUserId(userId);
    }

    @Override
    public List<Notice> getNoticesByUserId(String userId) {
        return mapper.getNoticesByUserId(userId);
    }
}
