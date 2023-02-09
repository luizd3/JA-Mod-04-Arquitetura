package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Animal;
import br.com.mentorama.alomundo.entities.Message;

public class MainAnimal {

    public static void main(String[] args) {
        System.out.println(Animal.factory("Gato Preto", "Gato"));
    }
}