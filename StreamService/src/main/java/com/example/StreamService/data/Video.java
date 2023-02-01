package com.example.StreamService.data;

import java.io.Serializable;

public class Video implements Serializable {


    private String name, description, path;


    public Video(String name, String description, String path) {

        this.name = name;
        this.description = description;
        this.path = path;
    }
    public Video(){}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
