package com.devyoung.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.devyoung.blog.vo.ListVO;

@Mapper
@Repository
public interface MainMapper {

	List<Map<String, Object>> selectTest();
	
	List<ListVO> getList();
	
	ListVO getDetail(int listNo);
	
	int save(ListVO dto);
	
	int delete(int listNo);
	
}
