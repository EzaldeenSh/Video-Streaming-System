package com.example.videosupload.controllers;

import com.example.videosupload.data.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Controller
public class UserController {
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

        WebClient webClient = webclientBuilder.baseUrl("authenticator:8081").build();



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
        else return "upload";

    }

}
