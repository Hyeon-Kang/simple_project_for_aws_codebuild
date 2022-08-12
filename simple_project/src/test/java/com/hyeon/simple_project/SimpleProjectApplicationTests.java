package com.hyeon.simple_project;

import com.hyeon.simple_project.service.SimpleService;
import com.hyeon.simple_project.vo.AwsCredentialsVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
//@PropertySource("classpath:application.properties")
// (properties = "src/test/resources/application.properties")
//@TestPropertySource(locations="src/test/resources/application.properties")
class SimpleProjectApplicationTests {

//	@Value("${aws.accessKey}")
//	private String accessKey;
//
//	@Value("${aws.secretKey}")
//	private String secretKey;
//
//	@Value("${aws.region}")
//	private String region;

//	@Test
//	void getProperties_test() {
//		SimpleService simpleService = new SimpleService();
//
//		// aws credentials vo의 속성을 null로 초기화
//		AwsCredentialsVo emptyCredentVo = new AwsCredentialsVo();
//		emptyCredentVo.setAccessKey(null);
//		emptyCredentVo.setSecretKey(null);
//		emptyCredentVo.setRegion(null);
//
//		emptyCredentVo = simpleService.getValuesVo(accessKey, secretKey, region);
//		assertNotEquals(emptyCredentVo.getAccessKey(), null);
//	}

}
