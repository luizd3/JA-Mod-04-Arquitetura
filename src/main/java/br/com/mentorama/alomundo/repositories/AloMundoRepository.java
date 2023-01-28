package br.com.mentorama.alomundo.repositories;

import br.com.mentorama.alomundo.entities.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AloMundoRepository {

    private static AloMundoRepository aloMundoRepository; //Guardar instância da própria classe (Singleton)

    private AloMundoRepository() {
        this.messages = new ArrayList<>();
    }

    public static AloMundoRepository getInstance() { //Prover instância da própria classe (Singleton)
        if (aloMundoRepository == null) {
            aloMundoRepository = new AloMundoRepository();
        }
        return aloMundoRepository;
    }

    private final List<Message> messages;

    public List<Message> findAll() {
        return messages;
    }

    public List<Message> findAll(String message) {
        return messages.stream()
                .filter(msg -> msg.getMessage().contains(message))
                .collect(Collectors.toList());
    }

    public Message findById(Integer id) {
        return messages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void add(Message message) {
        this.messages.add(message);
    }

    public void update(Message message) {
        messages.stream()
                .filter(msg -> msg.getId().equals(message.getId()))
                .forEach(msg -> msg.setMessage(message.getMessage()));
    }

    public void delete(Integer id) {
        messages.removeIf(msg -> msg.getId().equals(id));
    }

    public int count() {
        return messages.size();
    }
}
