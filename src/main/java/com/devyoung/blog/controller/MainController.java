package com.devyoung.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devyoung.blog.service.MainService;
import com.devyoung.blog.vo.ListVO;

@RestController
@RequestMapping("/api/v1")
public class MainController {
	
	@Autowired
	MainService service;

	@GetMapping("/test1")
	public Map<String, Object> test1() {
		System.out.println("=== test1 ===");
		Map<String, Object> result = new HashMap<>();
		result.put("res", service.selectTest());
		return result; 
	}
	
	@PostMapping("/test2")
	public Map<String, Object> test2() {
		System.out.println("=== test2 ===");
		Map<String, Object> result = new HashMap<>();
		result.put("res", "완료");
		return result; 
	}
	
	@GetMapping("/getList")
	public ResponseEntity<List<ListVO>> getList() {
		return ResponseEntity.ok().body(service.getList());
	} 
	
	@GetMapping("/getDetail/{listNo}")
	public ResponseEntity<ListVO> getDetail(@PathVariable("listNo") int listNo) {
		return ResponseEntity.ok().body(service.getDetail(listNo));
	}
	
	@PostMapping("/save")
	public ResponseEntity save(@RequestBody ListVO dto) {
		return ResponseEntity.ok().body(service.save(dto));
	}
	
	@PostMapping("/delete")
	public ResponseEntity delete(@RequestBody int listNo) {
		return ResponseEntity.ok().body(service.delete(listNo));
	}
}
