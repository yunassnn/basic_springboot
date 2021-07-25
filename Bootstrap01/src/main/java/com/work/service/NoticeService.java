package com.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.dao.NoticeDao;
import com.work.dto.Notice;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	public List<Notice> noticeList() {
		List<Notice> noticeList = noticeDao.selectNoticeList();
		return noticeList;
	}

	public Notice noticeDetail(String noticeNo) {
		Notice dto = noticeDao.selectNotice(noticeNo);
		return dto;
	}
}
