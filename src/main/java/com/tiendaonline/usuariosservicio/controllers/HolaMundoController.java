package com.tiendaonline.usuariosservicio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola Mundo Microservicio";
    }
}
