package com.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.dto.Rest;

@Mapper
public interface RestDao {

	public List<Rest> selectRestList();
	
	public Rest selectRest(String restNo);

}
