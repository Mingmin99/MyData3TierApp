package com.example.mydata.dao;

import com.example.mydata.dto.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int createNotice(Notice notice);

    List<Notice> getAllNoticesByUserId(String userId);
}