/*
4 - Leitura e escrita usando a classe JOptionPane.
Em vez de escrevermos as mensagens e resultados dos nossos programas para o canal standard
de output (o monitor), podemos escrever para um objecto gráfico. O programa que se segue
escreve duas mensagens numa caixa de diálogo do tipo JOptionPane:

b) Construa um pequeno programa que pergunte ao utilizador o seu nome e número e que
após a leitura escreva os valores lidos. 
 */
package aula1;

/**
 *
 * @author dlavareda
 */
import javax.swing.*;

public class Exercicio4 {

    public static void main(String[] args) {
        String s, n;
        int num;
        s = JOptionPane.showInputDialog(null, "Introduza o seu Nn: ");
        n = JOptionPane.showInputDialog(null, "Introduza o numero de aluno: ");
        num = Integer.parseInt(n);

        JOptionPane.showMessageDialog(null, "Olá " + s + " o teu numero é " + n);

        System.exit(0);
    }
}
