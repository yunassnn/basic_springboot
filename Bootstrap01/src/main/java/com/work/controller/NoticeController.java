package com.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.dto.Notice;
import com.work.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoticeController {

	@Autowired
	public NoticeService noticeService;
	
	@RequestMapping("/notice")
	public String noticeList(Model model) {
		List<Notice> noticeList = noticeService.noticeList(); 
		log.debug("notice controller 구동 :: " + noticeList.size());
		model.addAttribute("noticeList", noticeList);
		return "notice";
	}
	
	@RequestMapping("/noticeDetail")
	public String noticeDetail(String noticeNo, Model model) {
		Notice dto = noticeService.noticeDetail(noticeNo);
		model.addAttribute("dto",dto);
		return "noticeDetail";
	}
	
}
