/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

/**
 *
 * @author dlavareda
 */
public class testFila {

    public static void main(String[] args) {
        Fila filaA = new Fila(10);
        if (!filaA.cheia()) {
            filaA.inserir(123);
        } else {
            System.out.println("Erro: Fila Cheia");
        }

        filaA.inserir(12);
        System.out.println(filaA.toString());
        if (!filaA.vazia()) {
            System.out.println(filaA.retirar());

        } else {
            System.out.println("Erro: Fila Vazia");
        }
        System.out.println(filaA.toString());
        if (!filaA.vazia()) {
            System.out.println(filaA.retirar());
        } else {
            System.out.println("Erro: Fila Vazia");
        }
        System.out.println(filaA.toString());

        if (!filaA.vazia()) {
            System.out.println(filaA.retirar());
        } else {
            System.out.println("Erro: Fila Vazia");
        }
    }
}
