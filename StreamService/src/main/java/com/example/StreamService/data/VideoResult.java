package com.example.StreamService.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideoResult implements Serializable {
    private List<Video> videoResult;
    private int number;
    public VideoResult(){
        videoResult = new ArrayList<>();
        number = 0;
    }

    public VideoResult(List<Video> videoResult) {
        this.videoResult = videoResult;
        number = videoResult.size();

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "VideoResult{" +
                "videoResult=" + videoResult +
                ", number=" + number +
                '}';
    }

    public List<Video> getVideoResult() {
        return videoResult;
    }

    public void setVideoResult(List<Video> videoResult) {
        this.videoResult = videoResult;
    }
}
