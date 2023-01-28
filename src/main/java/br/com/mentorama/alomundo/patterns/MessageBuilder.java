package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Message;

public class MessageBuilder {

    private Integer id;
    private String message;
    private String autor;
    private String descricao;

    public MessageBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public MessageBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public MessageBuilder withAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public MessageBuilder withDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Message build() {
        return new Message(id, message, autor, descricao);
    }
}
