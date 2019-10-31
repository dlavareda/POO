/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1teste2017;

/**
 *
 * @author dlavareda
 */
public class Pergunta {

    private static int ultimo = 0;
    private int numero;
    private String texto;
    private double valor;

    public Pergunta() {
        ultimo++;
        numero = ultimo;
        texto = "";
        valor = 0.0;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        return "Numero: " + numero + " Texto: " + texto + " Valor: " + valor;
    }
}
