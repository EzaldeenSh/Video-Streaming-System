package com.example.SqlService.data;

import java.util.List;

public interface VideoDao {
    List<Video> findAll();
    boolean insertVideo(Video video);
}
