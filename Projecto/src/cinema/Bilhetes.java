/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.io.Serializable;

/**
 *
 * @author pacjt
 */
public class Bilhetes implements Serializable{
    private int nif;
    private int metodopagar; //[0] numerario; [1] multibanco; [2] MB WAY
    private int sessao;
    private double preco;
    private char fila;
    private int lugar;
    private int filme;
    
    public Bilhetes(){
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getMetodopagar() {
        return metodopagar;
    }

    public void setMetodopagar(int metodopagar) {
        this.metodopagar = metodopagar;
    }

    public int getSessao() {
        return sessao;
    }

    public void setSessao(int sessao) {
        this.sessao = sessao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getFilme() {
        return filme;
    }

    public void setFilme(int filme) {
        this.filme = filme;
    }
    
    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Bilhetes{" + ", nif=" + nif + 
                             ", metodopagar=" + metodopagar + 
                             ", sessao=" + sessao + 
                             ", preco=" + preco + 
                             ", fila=" + fila + 
                             ", lugar=" + lugar + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && getClass() == obj.getClass()){
            final Bilhetes other = (obj != null) ? (Bilhetes) obj : null;        // If obj isn't null, is declared as class Bilhetes, else null
            return (this == obj) ? true : ( this.metodopagar == other.metodopagar &&
                                            this.sessao      == other.sessao      &&
                                            this.lugar       == other.lugar       &&
                                            this.nif         == other.nif         &&
                                            this.preco       == other.preco       &&
                                            this.fila        == other.fila
                                           );
      
        } 
        return false;
    
    }
}
