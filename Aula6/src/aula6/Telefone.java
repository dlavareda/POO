/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

/**
 *
 * @author dlavareda
 */
public class Telefone {

    private String tipo; // Casa | Emprego | Móvel | ...
    private int numero;

    public Telefone() {
        this.tipo = "";
        this.numero = 0;

    }

    public Telefone(String tipo, int numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        //tipo é uma variável local ao método
    }

    public void setNumero(int numero) {
        this.numero = numero;
        // numero é uma variável local ao método
    }

    public String toString() {
        String s = "Tipo: " + tipo + " Número: " + numero;
        return s;
    }

    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Telefone tel = (Telefone) obj;
            return (this.numero == tel.numero && this.tipo.equals(tel.tipo));
        } else {
            return false;
        }
    }

    public Object clone() {
        Telefone copia = new Telefone();
        copia.numero = this.numero;
        copia.tipo = this.tipo;
        return copia;
    }
}
