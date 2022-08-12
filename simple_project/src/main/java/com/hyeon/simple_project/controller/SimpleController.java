package com.hyeon.simple_project.controller;

import com.hyeon.simple_project.service.SimpleService;
import com.hyeon.simple_project.vo.AwsCredentialsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SimpleController {

//	@Value("${aws.accessKey}")
//	private String accessKey;
//
//	@Value("${aws.secretKey}")
//	private String secretKey;
//
//	@Value("${aws.region}")
//	private String region;

    @Autowired
    SimpleService simpService;

	// Home
	@GetMapping("/")
	public Map<String, String> getHome() {
		HashMap<String, String> msgMap = new HashMap<String, String>();
		msgMap.put("msg", "MySimpleProject~~");
		return msgMap;
	}

	@GetMapping("/health")
	public String getHealthCheck() {
		return "OK~~~";
	}

	// IAM 유저 목록 조회
//	@GetMapping("/iam/getUsers")
//	public List<String> getUsers() {
//		AwsCredentialsVo credentVo = simpService.getValuesVo(accessKey, secretKey, region);
//        return simpService.getIamUserList(credentVo);
//	}

	//  resource key test
//	@GetMapping("/iam/test")
//	public AwsCredentialsVo getValues() {
//		return simpService.getValuesVo(accessKey, secretKey, region);
//	}
}
