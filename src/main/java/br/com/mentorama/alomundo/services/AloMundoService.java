package br.com.mentorama.alomundo.services;

import br.com.mentorama.alomundo.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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

    public Message findById(Integer id) {
        return messages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Integer add(final Message message) {
        if (message.getId() == null) {
            message.setId(messages.size() + 1);
        }
        messages.add(message);
        return message.getId();
    }

    public void update(Message message) {
        messages.stream()
                .filter(msg -> msg.getId().equals(message.getId()))
                .forEach(msg -> msg.setMessage(message.getMessage()));
    }

    public void delete(Integer id) {
        messages.removeIf(msg -> msg.getId().equals(id));
    }
}
