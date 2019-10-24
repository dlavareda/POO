/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocarros;

import myinputs.Ler;

/**
 *
 * @author dlavareda
 */
public class testAutocarro {
    
    public static void main(String[] args) {
        Fila inspecao = new Fila(10);
        Fila oficina = new Fila(10);
        Fila pronto = new Fila(10);
        System.out.println("Qual o numero do autocarro");
        int numero = Ler.umInt();
        System.out.println(numero);
        int resp;
        do {
            System.out.println("Opção 1 – Chegada");
            System.out.println("Opção 2 - Reparação");
            System.out.println("Opção 3 - Reparado ");
            System.out.println("Opção 4 – Operacional");
            System.out.println("Opção 5 – Partida");
            System.out.println("Opção 6 – Fechar Programa");
            resp = Ler.umInt();
            switch (resp) {
                case 1:
                    inspecao.inserir(numero);
                    break;
                case 2:
                    inspecao.retirar(numero);
                    oficina.inserir(numero);
                    break;
                case 3:
                    oficina.retirar(numero);
                    pronto.inserir(numero);
                    break;
                case 4:
                    inspecao.retirar(numero);
                    pronto.inserir(numero);
                    break;
                case 5:
                    pronto.retirar(numero);
                    break;
            }
            
        } while (resp != 6);
        
    }
    
}
