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

        //Alinea a
        /*Construa um programa em que teste a declaração de variáveis.
        Teste cada um dos tipos primitivos da tabela anterior, declarando variáveis, atribuindo valores e
        escrevendo esses valores no ecrã.*/
        System.out.println("Alinea A");
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
        //Alinea b
        /*Usando os operadores aritméticos que conhece da linguagem C construa expressões simples
        com variáveis dos tipos int, long, float e double e escreva o resultado no ecrã.*/
        System.out.println("Alinea B");
        float soma = x + f;
        System.out.println("Soma de " + x + " + " + f + " = " + soma);
        double soma2 = l + d;
        System.out.println("Soma de " + l + " + " + d + " = " + soma2);
        System.out.println();
        //Alinea c
        /*As principais instruções de controle (if, for, while) são também iguais às da linguagem C.
        Para cada uma das alíneas que se seguem, resolva construindo 3 versões: usando um ciclo for;
        usando um ciclo while; usando um ciclo do … while. */
        System.out.println("Alinea C");
        System.out.println("C1 - Escreva os inteiros de 1 a 100");
        System.out.println("Usando FOR");
        int i;
        for (i = 1; i <= 100; i++) {
            System.out.println(i);
        }
        System.out.println("Usando While");
        i = 1;
        while (i <= 100) {
            System.out.println(i);
            i++;
        }
        System.out.println("Usando DO WHILE");
        i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 100);
        System.out.println();
        System.out.println("C2 - Escreva os inteiros de 100 a 1");
        System.out.println("Usando FOR");

        for (i = 100; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Usando While");
        i = 100;
        while (i >= 1) {
            System.out.println(i);
            i--;
        }
        System.out.println("Usando DO WHILE");
        i = 100;
        do {
            System.out.println(i);
            i--;
        } while (i >= 1);
        System.out.println();
        System.out.println("C3 - Calcule o somatório dos inteiros de 1 a 100 e escreva o resultado.");
        System.out.println("Usando FOR");
        int soma3 = 0;
        for (i = 0; i <= 100; i++) {
            soma3 = soma3 + i;
        }
        System.out.println("Soma = " + soma3);
        System.out.println("Usando WHILE");
        soma3 = 0;
        i = 0;
        while (i <= 100) {
            soma3 = soma3 + i;
            i++;
        }
        System.out.println("Soma = " + soma3);
        System.out.println("Usando DO WHILE");
        soma3 = 0;
        i = 0;
        do {

            soma3 = soma3 + i;
            i++;
        } while (i <= 100);
        System.out.println("Soma = " + soma3);
        System.out.println();
        System.out.println("Calcule o produto dos inteiros de 1 a 100 e escreva o resultado");
        System.out.println("Usando FOR");
        double produtorio = 1;
        for (i = 1; i <= 100; i++) {
            produtorio = produtorio * i;
        }
        System.out.println("Produtorio = " + produtorio);
        System.out.println("Usando WHILE");
        produtorio = 1;
        i = 1;
        while (i <= 100) {
            produtorio = produtorio * i;
            i++;
        }
        System.out.println("Produtorio = " + produtorio);
        System.out.println("Usando DO WHILE");
        produtorio = 1;
        i = 1;
        do {

            produtorio = produtorio * i;
            i++;
        } while (i <= 100);
        System.out.println("Produtorio = " + produtorio);
        System.out.println();
        System.out.println("C5 - Calcule o somatório dos inteiros impares de 1 a 100 e escreva o resultado");
        System.out.println("Usando FOR");
        soma3 = 0;
        for (i = 1; i <= 100; i += 2) {
            soma3 = soma3 + i;
        }
        System.out.println("Soma = " + soma3);
        System.out.println("Usando WHILE");
        soma3 = 0;
        i = 1;
        while (i <= 100) {
            soma3 = soma3 + i;
            i += 2;
        }
        System.out.println("Soma = " + soma3);
        System.out.println("Usando DO WHILE");
        soma3 = 0;
        i = 1;
        do {

            soma3 = soma3 + i;
            i += 2;
        } while (i <= 100);
        System.out.println("Soma = " + soma3);
        System.out.println();
    }
}
