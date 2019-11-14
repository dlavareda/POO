/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula8;

/**
 *
 * @author dlavareda
 */
public class testeDerivada {

    public static void main(String[] args) {
        Base b1 = new Base(1, 7);
        Derivada d = new Derivada(b1, 2, 6);
        System.out.println("b1 = " + d);
        System.out.println("Soma de b1 = " + b1.soma());
        Base b2 = new Base(4, 8);
        Derivada d2 = new Derivada(b2, 3, 7);
        System.out.println(b1.equals(d2));
        Derivada d3 = (Derivada) d2.clone();
        System.out.println(d2.equals(d3));
    }
}
