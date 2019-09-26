/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author dlavareda
 */
public class Exercicio5b {

    public static void main(String[] args) throws IOException {
        String s;
        int a;
        float b;
        boolean c;
        s = JOptionPane.showInputDialog(null, "Introduza um inteiro");
        a = Integer.parseInt(s);
        System.out.println("O valor inteiro é: " + a);
        s = JOptionPane.showInputDialog(null, "Introduza um float");
        b = Float.parseFloat(s);
        System.out.println("O valor float é: " + b);

        s = JOptionPane.showInputDialog(null, "Introduza um boolean");

        c = Boolean.valueOf(s);

        System.out.println("O valor boolean é: " + c);

        System.exit(0);
    }
}
