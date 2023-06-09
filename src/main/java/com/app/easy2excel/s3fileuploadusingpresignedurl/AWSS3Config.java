package com.app.easy2excel.s3fileuploadusingpresignedurl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSS3Config {
    @Value("${amazon.aws.accessKey}")
    private String accessKeyId;

    @Value("${amazon.aws.secretKey}")
    private String accessKeySecret;

    @Value("${amazon.aws.region}")
    private String s3RegionName;

    @Bean
    public AmazonS3 getAmazonS3Client() {
        final BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials("AKIA6I5LPAREVIF35B5K", "kMpaS5/fPPo+rspkgvmQYhY9tqjsrPrGZvwzqHd9");
        // Get Amazon S3 client and return the S3 client object
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                .withRegion("ap-southeast-1")
                .build();
    }
}
