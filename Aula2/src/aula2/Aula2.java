/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

/**
 *
 * @author dlavareda
 */
import java.io.*;

public class Aula2 {

    public static void main(String[] args) throws IOException {
        BufferedReader canal;
        canal = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escreva um inteiro: ");
        String s = canal.readLine();
        int i = Integer.parseInt(s);
        System.out.println("O inteiro foi: " + i);
        canal = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escreva um float: ");
        s = canal.readLine(); 
         float f = Float.parseFloat(s);
        System.out.println("O inteiro foi: " + s);
    }
   
}
