package com.example.videosupload.services;

import com.example.videosupload.data.Video;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.time.Duration;

public class UploadService {
    private final String bucketName = "videosawsbucket";
    private AwsCredentials awsCredentials;
    private AwsCredentialsProvider awsCredentialsProvider;
    private S3Client s3Client;
    private PutObjectRequest putObjectRequest;

    private WebClient.Builder webclientBuilder = WebClient.builder();

    public boolean uploadToSql(Video video){

        WebClient webClient = webclientBuilder.baseUrl("sqlservice:8083").build();
        boolean  isUploaded = webClient
                .put()
                .bodyValue(video)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(boolean.class)
                .block(Duration.ofSeconds(2));
        return isUploaded;
    }

    public void upload(MultipartFile video) throws IOException{
        WebClient webClient = webclientBuilder.baseUrl("http://s3service:8084").build();
        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", video.getResource());

         webClient.post()
                .uri("/")
                .body(BodyInserters.fromMultipartData(multipartBodyBuilder.build()))
                .retrieve()
                .bodyToMono(void.class)
                .block(Duration.ofSeconds(10));


    }
}
