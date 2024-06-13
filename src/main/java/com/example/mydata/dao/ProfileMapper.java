package com.example.mydata.dao;

import com.example.mydata.dto.Asset;
import com.example.mydata.dto.LoanCondition;
import com.example.mydata.dto.Notice;
import com.example.mydata.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProfileMapper {

    User getUserById(@Param("userId") String userId);


    List<Asset> getAssetsByUserId(@Param("userId") String userId);


    List<LoanCondition> getLoansByUserId(@Param("userId") String userId);


    List<Notice> getNoticesByUserId(@Param("userId") String userId);
}