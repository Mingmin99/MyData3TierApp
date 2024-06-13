package com.example.mydata.service;

import com.example.mydata.dao.NoticeMapper;
import com.example.mydata.dto.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesServiceImpl implements NoticesService {
    private final NoticeMapper mapper;

    public NoticesServiceImpl(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int createNotice(Notice notice) {
        return mapper.createNotice(notice);
    }

    @Override
    public List<Notice> getAllNoticesByUserId(String userId) {
        return mapper.getAllNoticesByUserId(userId);
    }
}