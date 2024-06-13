package com.example.mydata.service;

import com.example.mydata.dto.Notice;

import java.util.List;

public interface NoticesService {
    int createNotice(Notice notice);

    List<Notice> getAllNoticesByUserId(String userId);
}