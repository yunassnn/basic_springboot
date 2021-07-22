package com.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	public MemberService memberService;
	
	@RequestMapping("/index")
	public String main() {
		log.debug("홈 컨트롤러 구동 :: main() 실행 ");
		return "index";
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		log.debug("홈 컨트롤러 구동 :: loginForm() 실행 ");
		return "loginForm";
	}
	
	@RequestMapping("/login")
	public String login(String memberId, String memberPw) {
		log.debug("login user :: " + memberId + ", " + memberPw);
		String grade = memberService.login(memberId, memberPw);
		if(grade != null) {
			log.debug("login Success :: ");
			return "index";
		} else {
			log.debug("login Fail :: ");
			return "loginForm";
		}
	}
		
	@RequestMapping("/buttons")
	public String buttons() {
		log.debug("홈 컨트롤러 구동 :: buttons() 실행 ");
		return "buttons";
	}

	@RequestMapping("/cards")
	public String cards() {
		log.debug("홈 컨트롤러 구동 :: cards() 실행 ");
		return "cards";
	}

	@RequestMapping("/charts")
	public String charts() {
		log.debug("홈 컨트롤러 구동 :: charts() 실행 ");
		return "charts";
	}

	@RequestMapping("/register")
	public String register() {
		log.debug("홈 컨트롤러 구동 :: register() 실행 ");
		return "register";
	}
	
	@RequestMapping("/forgot-password")
	public String findPw() {
		log.debug("홈 컨트롤러 구동 :: findPw() 실행 ");
		return "forgot-password";
	}

	@RequestMapping("/blank")
	public String blank() {
		log.debug("홈 컨트롤러 구동 :: blank() 실행 ");
		return "blank";
	}
	
	
	
	
}
