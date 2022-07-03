package com.hyeon.simple_project.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsCredentialsVo implements Serializable {

    private static final long serialVersionUID = -5129628467395047900L;

    private String accessKey;

    private String secretKey;

    private String region;
}
