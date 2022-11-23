package br.com.mentorama.alomundo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

    private final List<Message> messages;

    public OlaMundoController() {
        this.messages = new ArrayList<>();
        Message message1 = new Message(1, "Olá Mundo");
        Message message2 = new Message(2, "Hello World");
        Message message3 = new Message(3, "Terceira Mensagem");
        this.messages.add(message1);
        this.messages.add(message2);
        this.messages.add(message3);

    }

    @GetMapping
    public List<Message> olaMundo(){
        return messages;
    }

}
