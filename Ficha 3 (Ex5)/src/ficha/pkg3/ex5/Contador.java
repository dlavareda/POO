/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha.pkg3.ex5;

/**
 *
 * @author dlavareda
 */
public class Contador {

    private int count;

    public Contador() {
        count = 0;
    }

    public Contador(int count) {
        this.count = count;
    }

    public int incrementaContador() {
        count++;
        return count;
    }

    public int incrementaContador(int contador) {
        count += contador;
        return count;
    }

    public int decrementarContador() {
        count--;
        return count;
    }

    public int decrementarContador(int n) {
        count -= n;
        return count;
    }

    public int getContador() {
        return count;
    }
    public String toString(){
        return "Contador = " + count;
    }
}
