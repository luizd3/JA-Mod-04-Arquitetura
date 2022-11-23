package br.com.mentorama.alomundo2;

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

    public OlaMundoController() {
        this.messages = new ArrayList<>();
//        Message message1 = new Message(1, "Olá Mundo");
//        Message message2 = new Message(2, "Hello World");
//        Message message3 = new Message(3, "Terceira Mensagem");
//        this.messages.add(message1);
//        this.messages.add(message2);
//        this.messages.add(message3);

    }

    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message){
        if (message != null) {
            return messages.stream()
                    .filter(msg -> msg.getMessage().contains(message))
                    .collect(Collectors.toList());
        }
        return messages;
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Integer id) {
        return messages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Message message) {
        if (message.getId() == null) {
            message.setId(messages.size() + 1);
        }
        messages.add(message);
        return new ResponseEntity<>(message.getId(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Message message) {
         messages.stream()
                 .filter(msg -> msg.getId().equals(message.getId()))
                 .forEach(msg -> msg.setMessage(message.getMessage()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        messages.removeIf(msg -> msg.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
