package com.work.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.work.dto.Member;

@Mapper
public interface MemberDao {
	
	/** login : return grade */
	public String login(String memberId, String memberPw);
	
	/** login : return domain */
	public Member loginToMember(String memberId, String memberPw);

	/** select all member */
	public List<Member> selectMemberList();
	
	/** select one member */
	public Member selectMember(String memberId);
	
	/** join */
	public int insertMember(Member dto);

	
	
}
