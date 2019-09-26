/*
5 - Declaração de constantes:
final float PI=3.14159273269;
a) Construa um programa que peça ao utilizador o valor do raio e depois calcule o
perímetro e a área de um círculo.
b) Construa um programa de teste que lhe permita ler valores do tipo float, double e
boolean.
 */
package aula1;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * 5z
 *
 * @author dlavareda
 */
public class Exercicio5 {

    public static void main(String[] args) throws IOException {
        final double PI = 3.14159273269;
        String r;
        double raio, perimetro;
        r = JOptionPane.showInputDialog(null, "Introduza o valor do raio");
        raio = Integer.parseInt(r);
        perimetro = (2 * PI * raio);
        System.out.println("O perímetro da circunferencia de raio " + raio + " é " + perimetro);
        System.exit(0);
     
    }
}
