package com.projet01.API_pessoas.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
public class ControladorPessoas {

    @GetMapping
    public String getBook(){
        return "API Teste!";
    }
}
