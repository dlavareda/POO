/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author dlavareda
 */
public class Teste {

    public static void main(String[] args) {
        String s, s2;
        s = "COVILHÃ";
        s2 = "UBI";
        System.out.println("Caracter 3 = " + s.charAt(3));
        System.out.println("Tamanho = " + s.length());
        System.out.println(s.indexOf("LH"));
        System.out.println(s.concat(s2));
        System.out.println(s.substring(4));
        System.out.println(s.compareTo("COVILHÃ")); //TRUE 
        System.out.println(s.compareTo("BlaBla")); //FALSE
    }
}
