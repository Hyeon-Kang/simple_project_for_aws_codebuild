package com.hyeon.simple_project.service;

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

    @Value("${aws.accessKey}")
    String accessKey;

    @Value("${aws.secretKey}")
    String secretKey;

    @Value("${aws.region}")
    String region;


    /**
     * 자격증명 생성
     * @return
     */
    public AwsBasicCredentials credentials() {
        // 자격증명 설정
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKey,
                secretKey);
        return awsCredentials;
    }

    /**
     * AWS IamClient 생성
     * @return
     */
    public IamClient iamClient() {
        // 자격증명 설정
        AwsBasicCredentials awsCredentials = credentials();

        // IAM 클라이언트 구성
        IamClient client = IamClient.builder().region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials)).build();
        return client;
    }

    /**
     * AWS Iam User 목록 획득
     * @return
     */
    public List<String> getIamUserList() {
        ArrayList<String> userList = new ArrayList<>();

        IamClient client = iamClient();

        try {

            boolean done = false;
            String newMarker = null;

            while(!done) {
                ListUsersResponse response;

                if (newMarker == null) {
                    ListUsersRequest request = ListUsersRequest.builder().build();
                    response = client.listUsers(request);
                } else {
                    ListUsersRequest request = ListUsersRequest.builder()
                            .marker(newMarker).build();
                    response = client.listUsers(request);
                }

                for(User user : response.users()) {
                    log.info("debug log = {}", user.userName());
                    String userName = user.userName();
                    String userId = user.userId();
                    userList.add(userName);
                }

                if(!response.isTruncated()) {
                    done = true;
                } else {
                    newMarker = response.marker();
                }
            }
        } catch (IamException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
//            System.exit(1);
        }

        return userList;
    }

    public List<Map> getValues() {
        ArrayList<Map> valueList = new ArrayList<>();
        Map<String, String> accessKey_map = new HashMap<String, String>();
        Map<String, String> secretKey_map = new HashMap<String, String>();
        Map<String, String> region_map = new HashMap<String, String>();
        accessKey_map.put("accessKey", accessKey);
        secretKey_map.put("secretKey", secretKey);
        region_map.put("region", region);

        valueList.add(accessKey_map);
        valueList.add(secretKey_map);
        valueList.add(region_map);

        return valueList;
    }


}
