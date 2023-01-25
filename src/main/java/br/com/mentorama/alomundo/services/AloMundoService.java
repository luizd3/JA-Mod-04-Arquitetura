package br.com.mentorama.alomundo.services;

import br.com.mentorama.alomundo.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AloMundoService {

    private final List<Message> messages;

    public AloMundoService() {
        this.messages = new ArrayList<>();
    }

    public List<Message> findAll(String message){
        if (message != null) {
            return messages.stream()
                    .filter(msg -> msg.getMessage().contains(message))
                    .collect(Collectors.toList());
        }
        return messages;
    }
}
