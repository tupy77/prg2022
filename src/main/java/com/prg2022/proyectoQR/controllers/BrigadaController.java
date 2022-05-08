package com.prg2022.proyectoQR.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/brigada"})

public class BrigadaController {
    @GetMapping("")
    @ResponseBody
    public String listado() {
        return "Public Content.";
    }
}
