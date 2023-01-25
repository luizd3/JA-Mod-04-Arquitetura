package br.com.mentorama.alomundo.services;

import br.com.mentorama.alomundo.entities.Message;
import br.com.mentorama.alomundo.repositories.AloMundoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AloMundoService {

    @Autowired
    private AloMundoRepository aloMundoRepository;

    public List<Message> findAll(String message){
        if (message != null) {
            return aloMundoRepository.findAll(message);
        }
        return aloMundoRepository.findAll();
    }

    public Message findById(Integer id) {
        return aloMundoRepository.findById(id);
    }

    public Integer add(final Message message) {
        if (message.getId() == null) {
            message.setId(aloMundoRepository.count() + 1);
        }
        aloMundoRepository.add(message);
        return message.getId();
    }

    public void update(final Message message) {
        aloMundoRepository.update(message);
    }

    public void delete(Integer id) {
        aloMundoRepository.delete(id);
    }
}
