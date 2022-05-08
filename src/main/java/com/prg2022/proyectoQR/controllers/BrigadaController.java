package com.prg2022.proyectoQR.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/brigada"})

public class BrigadaController {
    @GetMapping("")

    public ModelAndView getBrigadas(ModelAndView modelAndView) {
        modelAndView.setViewName("brigada");
        return modelAndView;
    }
}
