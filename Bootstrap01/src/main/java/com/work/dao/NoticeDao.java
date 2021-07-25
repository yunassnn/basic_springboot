package com.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.dto.Notice;

@Mapper
public interface NoticeDao {

	public List<Notice> selectNoticeList();

	public Notice selectNotice(String noticeNo);
	
	
	
}
