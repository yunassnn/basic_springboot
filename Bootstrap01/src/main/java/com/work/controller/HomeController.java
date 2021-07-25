package com.work.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.dto.Member;
import com.work.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	// 꼭 적기...
	@Autowired
	public MemberService memberService;
	
	@RequestMapping("/index")
	public String main() {
		log.debug("홈 컨트롤러 구동 :: main() 실행 ");
		return "index";
	}

	@RequestMapping("/index_b")
	public String mian2() {
		log.debug("홈 컨트롤러 구동 :: main2() 실행 ");
		return "index_b";
	}

	@RequestMapping("/noticeList")
	public String noticeList() {
		log.debug("홈 컨트롤러 구동 :: noticeList() 실행 ");
		return "noticeList";
	}

	

	@RequestMapping("/loginForm")
	public String loginForm() {
		log.debug("홈 컨트롤러 구동 :: loginForm() 실행 ");
		return "loginForm";
	}
	
	@RequestMapping("/login")
	public String login(String memberId, String memberPw, HttpSession session) {
		log.debug("login user :: " + memberId + ", " + memberPw);

		String grade = memberService.login(memberId, memberPw);
		log.debug("login grade :: " + grade);

		Member dto = memberService.loginToMember(memberId, memberPw);		
		log.debug("dto :: " + dto);
		
		if(grade != null && dto != null) {
			session.setAttribute("memberId", memberId);
			session.setAttribute("grade", grade);
			session.setAttribute("dto", dto);
			
			log.debug("login Success :: ");
			return "index";
		} else {
			log.debug("login Fail :: ");
			return "404";
		}
	}
	
	@RequestMapping("/deleteForm")
	public String deleteForm() {
		log.debug("deleteForm Load :: ");
		return "deleteForm";
	}
	
	@RequestMapping("/deleteMember")
	public String deleteMember(String memberId, String memberPw) {
		log.debug("deleteMember Load :: ");
		log.debug(memberId + ", " + memberPw);
		boolean result = memberService.deleteMember(memberId, memberPw);
		if(result == true) {
			log.debug("회원탈퇴 성공 :: ");
			return "loginForm";
		} else {
			log.debug("회원탈퇴 실패 :: ");
			return "deleteForm";
		}
	}
	
	@RequestMapping("/alertTest")
	public String alertTest() {
		log.debug("신고접수팝업");
		return "/alertTest";
	}

	@RequestMapping("/restList")
	public String restList() {
		log.debug("rest List");
		return "/restList";
	}
	
	@RequestMapping("/testList")
	public String testList(Model model) {
		List<Member> list = memberService.memberList();
		log.debug("리스트 사이즈 :: " + list.size());
		model.addAttribute("list", list);
		return "testList";
	}
	
	@RequestMapping("/buttons")
	public String buttons() {
		log.debug("홈 컨트롤러 구동 :: buttons() 실행 ");
		return "buttons";
	}

	
	@RequestMapping("/blank")
	public String blank() {
		log.debug("홈 컨트롤러 구동 :: blank() 실행 ");
		return "blank";
	}
	
	
	
	
}
