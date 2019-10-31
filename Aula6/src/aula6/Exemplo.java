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
public class Exemplo {

    private int n;
    private String s;
    private ArrayList<Integer> listaX;
    private ArrayList<Telefone> listaT;

    public Exemplo() {
        n = 0;
        s = "";
        listaX = new ArrayList<Integer>();
        listaT = new ArrayList<Telefone>();
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public ArrayList<Integer> getListaX() {
        return listaX;
    }

    public void setListaX(ArrayList<Integer> L) {
        
        for (int i = 0; i < L.size(); i++) {
            listaX.add(i,  L.get(i)); 
        }
    }
    public ArrayList<Telefone> getListaT() {
        return listaT;
    }

    public void setListaT(ArrayList<Telefone> L) {
        
        for (int i = 0; i < L.size(); i++) {
            listaT.add(i,  L.get(i)); 
        }
    }
}
