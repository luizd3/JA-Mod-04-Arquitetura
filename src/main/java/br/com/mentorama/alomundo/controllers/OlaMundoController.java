package br.com.mentorama.alomundo.controllers;

import br.com.mentorama.alomundo.Message;
import br.com.mentorama.alomundo.services.AloMundoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

    private final List<Message> messages;

    @Autowired
    private AloMundoService aloMundoService;

    public OlaMundoController() {
        this.messages = new ArrayList<>();
    }

    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message){
        return aloMundoService.findAll(message);
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Integer id) {
        return aloMundoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Message message) {
        Integer id = aloMundoService.add(message);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Message message) {
        aloMundoService.update(message);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        aloMundoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
