/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjar;

/**
 *
 * @author dlavareda
 */
public class TestJar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, c;

        System.out.println("Introduza um numero");
        a = myinputs.Ler.umInt();
        System.out.println("Introduza um numero");
        b = myinputs.Ler.umInt();
        System.out.println("Introduza um numero");
        c = myinputs.Ler.umInt();
        if (a > b && a > c) {
            System.out.println("O maior é o A: " + a);
        } else if (b > a && b > c) {
            System.out.println("O maior é o B: " + b);
        } else {
            System.out.println("O maior é o C: " + c);
        }
    }

}

/*
4 – Escreva um programa que leia 3 inteiros do teclado e mostre o maior. 
 */
