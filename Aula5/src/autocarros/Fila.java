/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocarros;

/**
 *
 * @author dlavareda
 */
public class Fila {
    // variáveis de instância

    private int[] fila;
    private int n_elementos, dim, in, out;

    // construtor
    public Fila(int n) {
        dim = n;
        fila = new int[dim];
        in = 0;
        out = 0;
    }
    // métodos de instância

    public void inserir(int e) {
        fila[in] = e;
        n_elementos++;
        in = (in + 1) % dim;
    }

    public int retirar() {
        int e = fila[out];
        n_elementos--;
        out = (out + 1) % dim;
        return e;
    }

    public boolean cheia() {
        return (n_elementos == dim);
    }

    public boolean vazia() {
        return (n_elementos == 0);
    }

    public String toString() {
        String s = "Dimensão = " + dim + " Ocupação = " + n_elementos + "\n";
        for (int i = 0; i < n_elementos; i++) {
            s += " Elemento "+ i + " = " + fila[i]  + "\n";
        }
        return s;
    }
}
