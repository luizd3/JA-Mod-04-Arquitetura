package br.com.mentorama.alomundo.processors;

import br.com.mentorama.alomundo.entities.Message;

public interface Processor {

    void process(Message message);
}
