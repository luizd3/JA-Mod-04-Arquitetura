package br.com.mentorama.alomundo.processors;

import br.com.mentorama.alomundo.entities.Message;
import org.springframework.stereotype.Component;

@Component
public class ContarPalavras implements Processor {

    @Override
    public void process(Message message) {
        System.out.println("Contando palavras " + 10);
    }
}
