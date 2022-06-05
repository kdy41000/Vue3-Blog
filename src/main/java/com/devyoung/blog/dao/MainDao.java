package com.devyoung.blog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devyoung.blog.mapper.MainMapper;
import com.devyoung.blog.vo.ListVO;

@Repository
public class MainDao {

	@Autowired
    private MainMapper mapper;
	
	public List<Map<String, Object>> selectTest(){ 
		return mapper.selectTest(); 
	}
	
	public List<ListVO> getList() {
		return mapper.getList();
	}
	
	public ListVO getDetail(int listNo) {
		return mapper.getDetail(listNo);
	}
	
	public int save(ListVO dto) {
		return mapper.save(dto);
	}
	
	public int delete(int listNo) {
		return mapper.delete(listNo);
	}
}
