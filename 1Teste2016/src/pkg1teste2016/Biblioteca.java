/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1teste2016;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author dlavareda
 */
public class Biblioteca {

    private String nome;
    private String email;
    private ArrayList<Livro> livros;// Create an ArrayList object

    public Biblioteca() {
        nome = "";
        email = "";
        livros = new ArrayList<Livro>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addLivros(Livro L) {
        livros.add(L);
    }

    public String toString() {
        String s = "Nome: " + nome + "\nEmail: " + email;
        for (int i = 0; i < livros.size(); i++) {
            s += "\nLivro " + (i + 1) + ":\n " + livros.get(i);
        }
        return s;
    }

    public boolean procura(String nome) {
        Livro L;
        for (int i = 0; i < livros.size(); i++) {
            L = livros.get(i);
            if (L.getNome() == nome) {
                return true;
            }
        }
        return false;
    }

    public double valorTotalLivros() {
        double soma = 0;
        Livro L;
        for (int i = 0; i < livros.size(); i++) {
            L = livros.get(i);
            soma += L.getPreco();
        }
        return soma;
    }
}
