package com.devyoung.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devyoung.blog.dao.MainDao;
import com.devyoung.blog.service.MainService;
import com.devyoung.blog.vo.ListVO;


@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	MainDao dao;
	
	@Override
	public List<Map<String, Object>> selectTest() {
		return dao.selectTest();
	}

	@Override
	public List<ListVO> getList() {
		return dao.getList();
	}

	@Override
	public ListVO getDetail(int listNo) {
		return dao.getDetail(listNo);
	}

	@Override
	public int save(ListVO dto) {
		return dao.save(dto);
	}
	
	@Override
	public int delete(int listNo) {
		return dao.delete(listNo);
	}
	
}
