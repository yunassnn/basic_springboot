package com.work.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.dto.Member;
import com.work.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		return "main"; 
	}
	
	@RequestMapping("/joinForm")
	public String joinForm(Model model, HttpSession session) {
		
		return "joinForm";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/join")
	public String join(Member dto, Model model) {
		int result = memberService.addMember(dto);
		log.info("회원가입요청 :: ");
		if(result == 1) {
			model.addAttribute("message", "[join user] :: ");
			return "loginForm";
		} else {
			model.addAttribute("message", "[join user] :: FAIL ");
			return "result";
		}
	}
		
	@RequestMapping("/login")
	public String login(String memberId, String memberPw, Model model, HttpSession session) {
		log.debug(session.isNew() + ", " + session.getId());
		log.info("로그인 요청 :: ");
		log.debug(memberId + ", " + memberPw);
		
		String grade = memberService.login(memberId, memberPw);
		Member dto = memberService.loginToMember(memberId, memberPw);
		
		System.out.println("login grade :: " + grade);
		
		if(grade != null && dto != null) {
			
			session.setAttribute("memberId", memberId); // 다시 새로운 세션객체를 생성
			session.setAttribute("grade", grade);

			session.setAttribute("dto", dto);
			model.addAttribute("message", "[login user] :: " + memberId);
			return  "main";
		} else {
			model.addAttribute("message", "[login fail] 로그인 정보를 다시 확인하세요");			
			return "result";
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 세션객체 가져와서(DI) 세션설정정보 삭제처리
		Enumeration<String> attributes = session.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = attributes.nextElement();
			log.debug("attribute :: " + attribute + ":" + session.getAttribute(attribute));
			session.removeAttribute(attribute);
		}
		session.invalidate();
		return "main";
	}
	
	@RequestMapping("/memberList")
	public String memberList(Model model, HttpSession session) {
				
		List<Member> list = memberService.memberList();
		log.debug("memberList" + list.size());
		model.addAttribute("list", list);
		return "memberList";
	}
	
	@RequestMapping("/memberDetail")
	public String memberDetail(String memberId, Model model) {
		Member dto = memberService.memberDetail(memberId);
		model.addAttribute("dto", dto);
		return "memberDetail";
	}

	@RequestMapping("/multipleCondition")
	public String multipleCondition(String condition, String keyword, Model model) {
		log.debug("condition :: " + condition + ", keyword :: " + keyword);
		List<Member> list = null;
		if(keyword.contains(",")) {
			String[] memberIdList = keyword.split(",");
			memberService.memberIdListByCondition(condition, memberIdList);
			
		}
		
		list = memberService.memberListByCondition(condition, keyword);
		if(list.isEmpty()) {
			model.addAttribute("message", "검색 조건에 해당하는 회원정보가 없습니다");
		}
		
		model.addAttribute("list", list);
		
		return "memberList";
	}

	@RequestMapping("/myInfo")
	public String myInfo(String memberId, Model model, HttpSession session) {
		memberId = (String) session.getAttribute(memberId);
		Member dto = memberService.myInfo(memberId);
		model.addAttribute("dto", dto);
		return "memberDetail";
	}
	
	@RequestMapping("/myInfoUpdate")
	public String myInfoUpdate() {
		return null;
	}
	
	@RequestMapping("/findMyId")
	public String findMyId(String name, String mobile, String email) {
		return null;
	}
	
	@RequestMapping("/findMyPw")
	public String findMyPw(String memberId, String name, String email) {
		return null;
	}
	
	
}
