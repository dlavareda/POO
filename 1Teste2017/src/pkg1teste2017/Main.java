/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1teste2017;

/**
 *
 * @author dlavareda
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pergunta P1 = new Pergunta();
        Pergunta P2 = new Pergunta();
        Pergunta P3 = new Pergunta();
        P1.setTexto("Pergunta 1");
        P1.setValor(1);
        P2.setTexto("Pergunta 2");
        P2.setValor(2);
        P3.setTexto("Pergunta 3");
        P3.setValor(3);

        Frequencia F1 = new Frequencia("POO", 3);

        Pergunta[] PS = new Pergunta[3];
        for (int i = 0; i < 3; i++) {
            PS[i] = new Pergunta();
        }

        PS[0].setNumero(P1.getNumero());
        PS[0].setTexto(P1.getTexto());
        PS[0].setValor(P1.getValor());

        PS[1].setNumero(P2.getNumero());
        PS[1].setTexto(P2.getTexto());
        PS[1].setValor(P2.getValor());

        PS[2].setNumero(P3.getNumero());
        PS[2].setTexto(P3.getTexto());
        PS[2].setValor(P3.getValor());

        F1.setPerguntas(PS);

        Frequencia F2 = new Frequencia("POO", 3);
        F2.setPerguntas(F1.getPerguntas());

        
        System.out.println(F1.toString());
        
        System.out.println("Cotação total do teste = "+F1.somaCotacoesTeste());
       
    }

}
