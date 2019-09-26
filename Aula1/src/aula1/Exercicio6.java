/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1;

/**
 *
 * @author dlavareda
 */
public class Exercicio6 {

    public static void Main(String[] args) {
        int numero;
        int p[] = new int[2];
        Double decNum, rD;
        numero = -100000;
        decNum = 12345.6789;
        System.out.println("O valor da variável inteira é: " + numero);
        System.out.println("O valor da variável real é: " + decNum);
        char letra = 'A';
        System.out.println(letra);
        letra = 65;
        System.out.println(letra);
        letra = (char) -97;
        System.out.println(letra);
        Double z = -1.0;
        double x = 12.5, y = 3E30F, zero, rF;
        zero = 0.0;
        byte b = -128, rB; //limite dos byte é -128 a 127
        short xpto = -130, sht = 9, rS;
        long lng = 0x7FFFFFFFFFFF9B30L, rL;  // (0xEFFFFFFFFFFFFFFF)17293822569102704639 é maior do que o maior long possivel : (0x7FFFFFFFFFFF9B30) 9223372036854750000
        System.out.println(lng);
        rL = lng * 10;
        System.out.println("rL: " + rL);
        rF = lng + 1;
        System.out.println("rF: " + rF);
        rF = x * y / decNum;
        System.out.println("rF: " + rF);
        rD = x * y / p[1];
        System.out.println("rD: " + rD);
        rF = 0 / 0;
        System.out.println("rF: " + rF);
        rF = sht + b * y * x * lng;
        System.out.println("rF: " + rF);
        rD = -b * (sht + zero + x * lng + y * decNum * -numero / letra);
        System.out.println("rD: " + rD);
        rD *= 1E269;
        System.out.println("rD: " + rD);
    }
}
