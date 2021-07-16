package com.work.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.dao.MemberDao;
import com.work.dto.Member;
import com.work.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	/** login : return grade */
	public String login(String memberId, String memberPw) {
		String grade = memberDao.login(memberId, memberPw);
		System.out.println("member grade :: " + grade);
		return grade;
	}

	/** login : retrun domain*/
	public Member loginToMember(String memberId, String memberPw) {
		Member dto = memberDao.loginToMember(memberId, memberPw);
		log.debug("loginToMember :: " + dto);
		return dto;
	}

	/** join */
	public int addMember(Member dto) {
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setGrade("G");
		dto.setMileage(1000);
		
		return memberDao.insertMember(dto);
	}

	public List<Member> memberList() {
		List<Member> list = memberDao.selectMemberList();
		return list;
	}

	public Member memberDetail(String memberId) {
		Member dto = memberDao.selectMember(memberId);
		return dto;
	}

	
	
	
}