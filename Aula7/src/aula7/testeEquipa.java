/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

/**
 *
 * @author dlavareda
 */
public class testeEquipa {

    public static void main(String[] args) {
        Equipa E1 = new Equipa("Benfica");
        Equipa E2 = new Equipa("Alverca");
        //Teste adicionar jogador
        Jogador j1 = new Jogador("Manuel Silva", 2500.0);
        for (int i = 1; i < 35; i++) {
            j1.setGolosJornada(5, i);
        }
        Jogador j2 = new Jogador("Mantorras", 2500.0);
        for (int i = 1; i < 35; i++) {
            j2.setGolosJornada(6, i);
        }
        Jogador j3 = new Jogador("Reinaldo", 2500.0);
        for (int i = 1; i < 35; i++) {
            j3.setGolosJornada(2, i);
        }
        E1.addJogador(j1);
        E1.addJogador(j2);
        E1.addJogador(j3);
        System.out.println(E1);

        //Teste remover jogador at i
        E1.removerJogadorI(2);
        System.out.println(E1);

        //Teste count jogadores
        System.out.println("Numero de jogadores: " + E1.countJogadores());

        //Teste procura jogador
        System.out.println(E1.searchJogador("Mantorras"));
        System.out.println(E1.searchJogador("Figo"));

        //Teste melhor marcador
        System.out.println(E1.melhorMarcador());

        //Teste equals
        System.out.println(E1.equals(E1));
        System.out.println(E1.equals(E2));
        
        //Teste clone
        Equipa E3 = new Equipa("Aves");
        E3 = (Equipa)E1.clone();
        System.out.println(E3);
    }
}
