/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author dlavareda
 */
public class testeBiblioteca {

    public static void main(String[] args) {
        Biblioteca B1 = new Biblioteca();
        B1.setNome("Biblioteca da UBI");

        ArrayList<String> L = new ArrayList<String>();
        L.add("Dicionario");
        L.add("Gramática");
        B1.setLivros(L);
        System.out.println(B1.toString());
        System.out.println("\n");
        System.out.println("Dicionario existe na biblioteca?");
        System.out.println(B1.procura("Dicionario"));
        System.out.println("\n");
        System.out.println("POO existe na biblioteca?");
        System.out.println(B1.procura("POO"));
        System.out.println("\n");
        System.out.println("Tentar adicionar livro Dicionario");
        B1.adicionaLivro("Dicionario");
        System.out.println("\n");
        System.out.println("Tentar adicionar livro Programação");
        B1.adicionaLivro("Programação");
        System.out.println("\n");
        System.out.println(B1.toString());
        System.out.println("\n");
        System.out.println("Tentar adicionar livro POO");
        B1.removerLivro("POO");
        System.out.println("\n");
        System.out.println("Tentar adicionar livro Gramatica");
        B1.removerLivro("Gramática");
        System.out.println("\n");
        System.out.println(B1.toString());

    }
}
