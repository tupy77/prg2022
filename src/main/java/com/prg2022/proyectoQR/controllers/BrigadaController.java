package com.prg2022.proyectoQR.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/brigada"})

public class BrigadaController {
    @GetMapping("")

    public ModelAndView getBrigadas(ModelAndView modelAndView, Model pagina) {
        pagina.addAttribute("titulo", "Brigadas");
        modelAndView.addObject("pagina", pagina);
        modelAndView.setViewName("brigada");
        return modelAndView;
    }
}

