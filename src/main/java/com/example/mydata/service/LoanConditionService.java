package com.example.mydata.service;

import com.example.mydata.dto.LoanCondition;

import java.util.List;

public interface LoanConditionService {
    List<LoanCondition> getLoanConditionsByUserId(String userid);
}