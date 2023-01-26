package br.com.mentorama.alomundo.processors;

import br.com.mentorama.alomundo.entities.Message;
import org.springframework.stereotype.Component;

@Component
public class RemoverPalavrasIndevidas implements Processor {

    @Override
    public void process(final Message message) {
        System.out.println("Removendo palavras indevidas");
    }
}
