package com.prg2022.proyectoQR;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Text {
    @GetMapping("/")

    public String text(){
        return "master";
    }

    @GetMapping("/login")

    public String login(){
        return "login";
    }
    
}
