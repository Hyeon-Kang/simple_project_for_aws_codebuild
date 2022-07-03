package com.hyeon.simple_project.controller;

import com.hyeon.simple_project.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/iam")
public class SimpleController {

    @Autowired
    SimpleService simpService;

	// 조직 내 정책 리스트 보기
	@GetMapping("/getUsers")
	public List<String> getUsers() {
        return simpService.getIamUserList();
	}

	@GetMapping("/test")
	public List<Map> getValues() {
		return simpService.getValues();
	}
}
