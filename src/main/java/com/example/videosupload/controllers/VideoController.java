package com.example.videosupload.controllers;

import com.example.videosupload.data.Video;
import com.example.videosupload.services.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class VideoController {

    private UploadService uploadService = new UploadService();



    @PostMapping("/upload")
    public String uploadVideo(@RequestParam(value = "video") MultipartFile video,
                              @RequestParam(value = "description") String description, Model model) throws IOException {

        String videoPath ="https://videosawsbucket.s3.amazonaws.com/" + video.getOriginalFilename();
        Video video1 = new Video(video.getOriginalFilename(), description, videoPath);
        uploadService.uploadToSql(video1);
        uploadService.upload(video);
        model.addAttribute("successMessage","Video Uploaded");


        return "upload";
    }
}

