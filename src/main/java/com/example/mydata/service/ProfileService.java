package com.example.mydata.service;

import com.example.mydata.dto.Asset;
import com.example.mydata.dto.LoanCondition;
import com.example.mydata.dto.Notice;
import com.example.mydata.dto.User;

import java.util.List;

public interface ProfileService {
    User getUserById(String userId);

    List<Asset> getAssetsByUserId(String userId);

    List<LoanCondition> getLoansByUserId(String userId);

    List<Notice> getNoticesByUserId(String userId);
}