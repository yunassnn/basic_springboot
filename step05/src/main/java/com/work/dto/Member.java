package com.work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private String memberId;
	
	private String memberPw;
	
	private String name;
	
	private String mobile;
	
	private String email;
	
	private String entryDate;
	
	private String grade;
	
	private int mileage;
	
	private String manager;
	
}