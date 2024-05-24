package com.example.mydata.service;

import com.example.mydata.dao.LoanConditionMapper;
import com.example.mydata.dto.LoanCondition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanConditionServiceImpl implements LoanConditionService {
    private final LoanConditionMapper mapper;

    public LoanConditionServiceImpl(LoanConditionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<LoanCondition> getLoanConditionsByUserId(String userid) {
        return mapper.getLoanConditionsByUserId(userid);
    }
}
