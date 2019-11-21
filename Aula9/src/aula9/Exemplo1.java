package aula9;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dlavareda
 */
public class Exemplo1 {

    private static String leStr() /*throws IOException*/ {
        int ch;
        String r = "";
        boolean fim = false;
        while (!fim) {
            try {
                ch = System.in.read();
                if (ch < 0 || (char) ch == '\n') {
                    fim = true;
                } else {
                    r = r + (char) ch;
                }
            } catch (java.io.IOException e) {
                fim = true;
            }
        }
        return r;
    }

    public static void main(String[] args) /*throws IOException*/ {
        int index = -1;
        String palavra = " ";
        String[] tabPal = new String[10];
        System.out.print("Introduza uma palavra: ");

        palavra = leStr();

        while (!palavra.equals("fim")) {
            index = -1;
            while (index < 0 || index > 9) {
                System.out.print("Introduza um índice: ");
                try {
                    index = Integer.valueOf(leStr().trim()).intValue();
                    tabPal[index] = palavra;
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Não é um numero inteiro entre 0 e 9");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ERRO: 0 <= índice <= 9");

                }
            }
            System.out.print("Introduza uma palavra");
            System.out.println("(para terminar escreva fim): ");
            palavra = leStr();

        }
    }
}
