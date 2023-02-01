package com.example.SqlService.controllers;


import com.example.SqlService.data.Video;
import com.example.SqlService.data.VideoDaoUser;

import com.example.SqlService.data.VideoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class sqlController {


    @Autowired
    public sqlController(VideoDaoUser videoDaoUser) {
        this.videoDaoUser = videoDaoUser;
    }

    private final VideoDaoUser videoDaoUser;
    @RequestMapping( method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean uploadVideo(@RequestBody Video video){
        return videoDaoUser.insertVideo(video);
    }

    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public VideoResult getVid   eos(){
        ArrayList<Video> videos = new ArrayList<>();
        videos = (ArrayList<Video>) videoDaoUser.findAll();
         return new VideoResult(videos);
    }

}

