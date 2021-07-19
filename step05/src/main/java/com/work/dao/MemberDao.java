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

	/** 다중조건 검색 */
	public List<Member> selectMemberListByCondition(String condition, String keyword);

	/** 여러 아이디 검색 */
	public List<Member> selectMemberIdListByCondition(String condition, String[] memberIdList);

	
	
}
