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
import java.util.concurrent.ThreadLocalRandom;

public class Ficha3Ex5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        Contador c1 = new Contador();

        c1.incrementaContador();
        s = c1.toString();
        System.out.println(s);
        c1.incrementaContador(10);
        s = c1.toString();
        System.out.println(s);
        c1.decrementarContador();
        s = c1.toString();
        System.out.println(s);
        c1.decrementarContador(5);
        s = c1.toString();
        System.out.println(s);
        System.out.println(c1); //5.c

        /*d) Construa um programa que gere aleatoriamente N valores inteiros no intervalo de
        [–100, 100[ sendo o valor de N dado pelo utilizador. Usando objectos da classe Contador o
        programa deverá contar quantos valores gerados são positivos e quantos são negativos.*/
        int NumeroAleatorio, count;
        System.out.println("Quantos Numeros");
        count = myinputs.Ler.umInt();
        Contador Positivos = new Contador();
        Contador Negativos = new Contador();
        for (int i = 0; i < count; i++) {
            NumeroAleatorio = ThreadLocalRandom.current().nextInt(-100, 100);
            System.out.println(NumeroAleatorio);
            if (NumeroAleatorio < 0) {
                Negativos.incrementaContador();
            } else {
                Positivos.incrementaContador();
            }
        }
        System.out.println("Existem " + Positivos + " positivos e " + Negativos + " negativos");
    }

}
