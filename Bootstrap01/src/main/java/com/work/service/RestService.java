package com.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.dao.RestDao;
import com.work.dto.Rest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestService {

	@Autowired
	private RestDao restDao;

	public List<Rest> restList() {
		List<Rest> restList = restDao.selectRestList();
		return restList;
	}
	
	public Rest restDetail(String restNo) {
		Rest dto = restDao.selectRest(restNo);
		log.debug("No.dto REST :: " + restNo + ", " + dto);
		return dto;
	}
}
