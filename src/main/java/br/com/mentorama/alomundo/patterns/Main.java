package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Message;

public class Main {

    public static void main(String[] args) {
        Message message = new MessageBuilder()
                .withId(1)
                .withMessage("Teste")
                .withDescricao("Descrição da mensagem")
                .build();
        System.out.println(message);
    }
}
