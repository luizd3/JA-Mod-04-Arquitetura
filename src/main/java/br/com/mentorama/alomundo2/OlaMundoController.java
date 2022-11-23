package br.com.mentorama.alomundo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

    private final String message = "Olá Mundo";

    @GetMapping
    public String olaMundo(){
        return message;
    }

}
