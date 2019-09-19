/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula0;

/**
 *
 * @author dlavareda
 */
public class Ex3 {

    public static void main(String[] args) {
        boolean z = false;
        char y = 'e';
        byte b = 1; 
        short s = (short) 123456;
        int x = 2019;
        long l = 125634859;
        float f = (float) 9.1234567;
        double d = 9.123456789012345;
        
        
        System.out.println("Boolean z = " + z);
        System.out.println("Char y = " + y);
        System.out.println("Byte b = " + b);
        System.out.println("Short s = " + s);
        System.out.println("Int x = " + x);
        System.out.println("Long l = " + l);
        System.out.println("Float f = " + f);
        System.out.println("Double d = " + d);
        System.out.println();
        float soma = x + f;
 System.out.println("Soma de " + x + " + " + f + " = "+soma);
    }
}
