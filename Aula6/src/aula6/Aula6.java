/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class Aula6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        lista.add("Maria");
        lista.add("João");
        String s = (String) lista.get(0);
        System.out.println(lista.toString() + " , " + s);
        
        System.out.println("Exercicio 2\n");
        ArrayList<String> lista1;
        lista1 = new ArrayList<String>();
        lista1.add("Joana");
        lista1.add("Manuel");
        String ss = lista1.get(0);
        System.out.println(lista1.toString() + " ," + ss);
    }

}
