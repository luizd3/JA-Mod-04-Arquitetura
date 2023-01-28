package br.com.mentorama.alomundo.entities;

public class Cachorro extends Animal {

    public Cachorro(final String nome, final String especie) {
        super(nome, especie);
        System.out.println("Au au");
    }
}
