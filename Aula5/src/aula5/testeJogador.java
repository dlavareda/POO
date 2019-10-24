/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5;

/**
 *
 * @author dlavareda
 */
public class testeJogador {

    public static void main(String[] args) {
        // TODO code application logic here

        Jogador j1 = new Jogador("Manuel Silva", 2500.0);
        for (int i = 1; i < 35; i++) {
            j1.setGolosJornada(5, i);
        }
        System.out.println(j1.toString());
        j1.aumentarSalario(25);
        System.out.println(j1.toString());

        j1.setGolosJornada(10, 2);
        System.out.println(j1.toString());

    }
}
