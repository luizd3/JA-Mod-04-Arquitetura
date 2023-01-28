package br.com.mentorama.alomundo.entities;

public class Gato extends Animal {

    public Gato(final String nome, final String especie) {
        super(nome, especie);
        System.out.println("Miau");
    }
}
