package com.devyoung.blog.service;

import java.util.List;
import java.util.Map;

import com.devyoung.blog.vo.ListVO;

public interface MainService {

	List<Map<String, Object>> selectTest();
	
	List<ListVO> getList();
	
	ListVO getDetail(int listNo);
	
	int save(ListVO dto);
	
	int delete(int listNo);
	
}
