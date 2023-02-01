package com.example.StreamService.controllers;

import com.example.StreamService.data.User;
import com.example.StreamService.data.Video;
import com.example.StreamService.data.VideoResult;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class LoginController {
    private List<Video> videos;
    private WebClient.Builder webclientBuilder = WebClient.builder();

    @GetMapping("/")
    public String display(){
        return "login";
    }

    @PostMapping("/login")
    public String getAuthentication(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password, Model model){
        User user1 = new User(username, password);
        boolean isValidated = false;

        WebClient webClient = webclientBuilder.baseUrl("authenticator:8081/").build();



        isValidated = webClient
                .post()
                .bodyValue(user1)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(boolean.class)
                .block(Duration.ofSeconds(2));



        if(!isValidated) {
            model.addAttribute("errorMessage", "Invalid Credentials!");
            return "login";
        }
        else {
            WebClient webClient2 = webclientBuilder.baseUrl("sqlservice:8083/").build();
            VideoResult videoResult = webClient2
                    .post()
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(VideoResult.class)
                    .block(Duration.ofSeconds(4));

            videos = videoResult.getVideoResult();
            model.addAttribute("videos", videos);

            return "selection";
        }
    }
    @PostMapping("/stream")
    public String displayVideo(@RequestParam(value = "selection") int selection, Model model){
        selection--;
        Video selectedVideo = videos.get(selection);
        model.addAttribute("path", selectedVideo.getPath());
        model.addAttribute("description", selectedVideo.getDescription());

        return "stream";
    }

}