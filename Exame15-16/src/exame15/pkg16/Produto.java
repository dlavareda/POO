/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exame15.pkg16;

import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class Produto {

    private static int last_id;
    private String nome;
    private int codigo;
    private int quantidade;
    private double preco;

    public Produto(String nome) {
        last_id++;
        codigo = last_id;
        this.nome = nome;
        this.quantidade = 0;
        this.preco = 0.0;
    }

    public static int getLast_id() {
        return last_id;
    }

    public static void setLast_id(int last_id) {
        Produto.last_id = last_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " Nome: " + nome + " Preco: " + preco + " Quantidade: " + quantidade;
    }

    public void subirProduto(double percentagem) throws ValorInvalido {
        if (percentagem > 0 && percentagem <= 100) {
            this.preco += this.preco * (percentagem / 100);
        } else {
            throw new ValorInvalido("O valor introduzido " + percentagem + " não está entre 0 e 100");
        }
    }

    public static String nomeProdutoMaisCaro(ArrayList<Produto> p) {
        int maior = 0;
        String nomeMaior = null;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getPreco() > maior) {
                nomeMaior = p.get(i).getNome();
            }
        }
        return nomeMaior;
    }

    public static int numeroProdutoByNome(ArrayList<Produto> p, String s) {
        int count = 0;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getNome().equals(s)) {
                count++;
            }
        }
        return count;

    }
}
