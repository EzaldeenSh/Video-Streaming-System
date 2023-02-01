package com.example.SqlService.data;

import java.io.Serializable;
import java.util.List;

public class VideoResult implements Serializable {
    private List<Video> videoResult;
    private int number;
    public VideoResult(){}

    public VideoResult(List<Video> videoResult) {
        this.videoResult = videoResult;
    }

    public List<Video> getVideoResult() {
        return videoResult;
    }

    public void setVideoResult(List<Video> videoResult) {
        this.videoResult = videoResult;
    }

    @Override
    public String toString() {
        return "VideoResult{" +
                "videoResult=" + videoResult +
                '}';
    }
}
