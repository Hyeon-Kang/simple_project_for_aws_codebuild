package com.hyeon.simple_project.service;

import com.hyeon.simple_project.vo.AwsCredentialsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.*;

import java.util.*;

@Slf4j
@Service
public class SimpleService {

//    @Value("${aws.accessKey}")
//    private String accessKey;
//
//    @Value("${aws.secretKey}")
//    private String secretKey;
//
//    @Value("${aws.region}")
//    private String region;

    public String getEchoService(String input_msg) {
        return input_msg;
    }


//    public AwsCredentialsVo getValuesVo(String accessKey, String secretKey, String region) {
//        AwsCredentialsVo credentVo = new AwsCredentialsVo();
//        credentVo.setAccessKey(accessKey);
//        credentVo.setSecretKey(secretKey);
//        credentVo.setRegion(region);
//        log.info("debug credentVo = {}", credentVo);
//        return credentVo;
//    }

    /**
     * 자격증명 생성
     * @return
     */
//    public AwsBasicCredentials credentials(AwsCredentialsVo credentVo) {
//        // 자격증명 설정
//        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(credentVo.getAccessKey(),
//                credentVo.getSecretKey());
//        return awsCredentials;
//    }

    /**
     * AWS IamClient 생성
     * @return
     */
//    public IamClient iamClient(AwsCredentialsVo credentVo) {
//        // 자격증명 설정
//        AwsBasicCredentials awsCredentials = credentials(credentVo);
//
//        // IAM 클라이언트 구성
//        IamClient client = IamClient.builder().region(Region.of(credentVo.getRegion()))
//                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials)).build();
//        return client;
//    }

    /**
     * AWS Iam User 목록 획득
     * @return
     */
//    public List<String> getIamUserList(AwsCredentialsVo credentVo) {
//        ArrayList<String> userList = new ArrayList<>();
//
//        IamClient client = iamClient(credentVo);
//
//        try {
//
//            boolean done = false;
//            String newMarker = null;
//
//            while(!done) {
//                ListUsersResponse response;
//
//                if (newMarker == null) {
//                    ListUsersRequest request = ListUsersRequest.builder().build();
//                    response = client.listUsers(request);
//                } else {
//                    ListUsersRequest request = ListUsersRequest.builder()
//                            .marker(newMarker).build();
//                    response = client.listUsers(request);
//                }
//
//                for(User user : response.users()) {
//                    log.info("debug log = {}", user.userName());
//                    String userName = user.userName();
//                    String userId = user.userId();
//                    userList.add(userName);
//                }
//
//                if(!response.isTruncated()) {
//                    done = true;
//                } else {
//                    newMarker = response.marker();
//                }
//            }
//        } catch (IamException e) {
//            System.err.println(e.awsErrorDetails().errorMessage());
//        }
//
//        return userList;
//    }
}
