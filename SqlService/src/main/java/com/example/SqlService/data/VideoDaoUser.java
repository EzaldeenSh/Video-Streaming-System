package com.example.SqlService.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantConditions")
@Repository
public class VideoDaoUser implements VideoDao{
    private Connection connection;
    private Statement statement;
    private List<Video> videos;
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Video> videoMapper;

    @Autowired
    public VideoDaoUser(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        videoMapper =(rs,rowNum)-> new Video(rs.getString("videoName"),rs.getString("videoDescription"),rs.getString("videoPath"));
        videos = new ArrayList<>();
    }
    @Override
    public List<Video> findAll() {
        return jdbcTemplate.query("SELECT * from videos",videoMapper);
    }


    @Override
    public boolean insertVideo(Video video) {
        jdbcTemplate.update(
                "INSERT INTO videos (videoName,videoDescription,videoPath) VALUES (?,?,?)",video.getName(),video.getDescription(),video.getPath());
        return true;
    }




}
