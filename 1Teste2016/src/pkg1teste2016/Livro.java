/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1teste2016;

/**
 *
 * @author dlavareda
 */
public class Livro {

    private int ID;
    private String nome;
    private double preco;
    private String[] autores;

    public Livro(int ID) {
        this.ID = ID;
        nome = "";
        preco = 0.0;
        autores = new String[3];
        for (int i = 0; i < 3; i++) {
            autores[i] = " ";
        }
    }

    public int getIdentificador() {
        return ID;
    }

    public String[] getAutores() {
        return autores;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public void setNome(String s) {
        nome = s;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setIdentificador(int ID) {
        this.ID = ID;
    }

    public void setAutores(String[] a) {
        for (int i = 0; i < a.length; i++) {
            this.autores[i] = a[i];
        }
    }

    public String toString() {
        String s = "ID: " + ID + "\nNome: " + nome + "\nPreço: " + preco;
        for (int i = 0; i < 3; i++) {
            s += "\n Autor " + (i + 1) + " : " + autores[i];
        }

        return s;
    }
}
