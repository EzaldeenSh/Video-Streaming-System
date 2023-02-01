package com.example.s3Service.controllers;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@RestController
public class S3Controller {
    private final String bucketName = "videosawsbucket";
    private AwsCredentials awsCredentials;
    private AwsCredentialsProvider awsCredentialsProvider;
    private S3Client s3Client;
    private PutObjectRequest putObjectRequest;



    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadVideo(@RequestPart("file") MultipartFile video)throws IOException {

            awsCredentials = AwsBasicCredentials.create("AKIAVC434M7GGNNGUEXH","dAoFH6vss45/0ZfejBf4yT2xf4B6UuK4plKj5+K2");
            awsCredentialsProvider = StaticCredentialsProvider.create(awsCredentials);
            s3Client = S3Client
                    .builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(awsCredentialsProvider)
                    .build();

            putObjectRequest = PutObjectRequest
                    .builder()
                    .bucket(bucketName)
                    .key(video.getOriginalFilename())
                    .acl("public-read")
                    .contentType("video/mp4")
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(video.getInputStream(),video.getInputStream().available()));




    }

}
