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
		if(session.getAttribute("memberId") == null || session.getAttribute("dto") == null) {
			model.addAttribute("message", "비정상 경로입니다. 로그인 후 이용하시길 바랍니다.");
			return "result";
		} else {
			if(!session.getAttribute("grade").equals("A") || !((Member)session.getAttribute("dto")).getGrade().equals("A")) {
				model.addAttribute("message", "관리자만 접속 가능합니다.");
				return "main";
			}
		}
		
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

	
}
