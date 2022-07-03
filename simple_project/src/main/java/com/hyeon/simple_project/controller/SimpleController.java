package com.hyeon.simple_project.controller;

import com.hyeon.simple_project.service.SimpleService;
import com.hyeon.simple_project.vo.AwsCredentialsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/iam")
public class SimpleController {

	@Value("${aws.accessKey}")
	private String accessKey;

	@Value("${aws.secretKey}")
	private String secretKey;

	@Value("${aws.region}")
	private String region;

    @Autowired
    SimpleService simpService;



	// IAM 유저 목록 조회
	@GetMapping("/getUsers")
	public List<String> getUsers() {
		AwsCredentialsVo credentVo = simpService.getValuesVo(accessKey, secretKey, region);
        return simpService.getIamUserList(credentVo);
	}

	@GetMapping("/test")
	public AwsCredentialsVo getValues() {
		return simpService.getValuesVo(accessKey, secretKey, region);
	}
}
