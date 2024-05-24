package com.example.mydata.dao;

import com.example.mydata.dto.LoanCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoanConditionMapper {


    List<LoanCondition> getLoanConditionsByUserId(String userid);
}
