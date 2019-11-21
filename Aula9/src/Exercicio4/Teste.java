/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio4;

/**
 *
 * @author dlavareda
 */
public class Teste {

    public static void main(String args[]) {
        int i, valor;
        int fornecedor[] = {20, 80, 70, 60, 100, 50, 60, 20};
        FrascoChocolates F = new FrascoChocolates(120, 50);
        for (i = 0; i < 8; i = i + 2) {
            try {
                valor = fornecedor[i];
                F.enche(valor);
                valor = fornecedor[i + 1];
                F.retira(valor);
            } catch (FrascoVazio e) {
                System.out.println(e.getMessage());
            } catch (FrascoCheio e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("fim da iteração " + i);
            }
        }
    }
}
