package com.work.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.dto.Rest;
import com.work.service.RestService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RestController {

	@Autowired
	public RestService restService;
	
	@RequestMapping("/restList")
	public String restList(Model model) {
		List<Rest> restList = restService.restList();
		log.debug("rest Controller 구동 :: restList()" + restList.size());
		model.addAttribute("restList", restList);
		return "restList";
	}
	
	@RequestMapping("/restDetail")
	public String restDetail(String restNo, Model model, HttpSession session) {
		Rest dto = restService.restDetail(restNo);
		log.debug("rest Controller 구동 :: restDetail : " + restNo);
		model.addAttribute("dto", dto);
		return "restDetail";
	}
	
}
