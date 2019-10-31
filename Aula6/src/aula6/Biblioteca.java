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
public class Biblioteca {

    private String nome;
    private ArrayList<String> livros;// Create an ArrayList object

    public Biblioteca() {
        nome = "";
        livros = new ArrayList<String>();
    }

    public Biblioteca(String nome) {
        this.nome = nome;
        livros = new ArrayList<String>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivros(ArrayList<String> L) {
        for (int i = 0; i < L.size(); i++) {
            livros.add(L.get(i));
        }
    }

    /*  public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            nome x = (nome) obj;
            return (this.conta =  = x.conta);
        } else {
            return false;
        }
    }*/
    public String toString() {
        String s = "Nome: " + nome;
        for (int i = 0; i < livros.size(); i++) {
            s += "\nLivro " + (i + 1) + ":\n " + livros.get(i);
        }
        return s;
    }

    public boolean procura(String nome) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).compareTo(nome) == 0) {
                return true;
            }
        }
        return false;
    }

    public void adicionaLivro(String nome) {
        if (procura(nome) == false) {//nao existe na biblioteca
            livros.add(nome);
            System.out.println("Livro " + nome + " adicionado a Biblioteca");
            return;
        }
        System.out.println("Livro " + nome + " já existe na Biblioteca");
    }

    public void removerLivro(String nome) {
        if (procura(nome) == false) {//nao existe na biblioteca
            System.out.println("Livro " + nome + " não existe na Biblioteca");
            return;
        }
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).compareTo(nome) == 0) {
                livros.remove(i);
                System.out.println("Livro " + nome + " removido com sucesso");
            }
        }
    }
}
