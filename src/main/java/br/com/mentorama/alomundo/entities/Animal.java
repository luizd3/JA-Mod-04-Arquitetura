package br.com.mentorama.alomundo.entities;

public abstract class Animal {

    public String nome;
    public String especie;

    public Animal(final String nome, final String especie) {
        this.nome = nome;
        this.especie = especie;
    }

    public static Animal factory(String nome, String especie) {
        if (especie.equals("Gato")) {
            return new Gato(nome, especie);
        } else if (especie.equals("Cachorro")) {
            return new Cachorro(nome, especie);
        }
        throw new RuntimeException("Especie inválida de animal.");
    }

}
