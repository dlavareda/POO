/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class Equipa {

    private String nome;
    private ArrayList<Jogador> Jogadores;

    public Equipa(String nome) {
        this.nome = nome;
        Jogadores = new ArrayList<Jogador>();
    }

    public void addJogador(Jogador J) {
        Jogadores.add(J);
    }

    public void removerJogadorI(int I) {
        Jogadores.remove(I);
    }

    public int countJogadores() {
        return Jogadores.size();
    }

    public boolean searchJogador(String nome) {
        for (int i = 0; i < Jogadores.size(); i++) {
            if (Jogadores.get(i).getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public String melhorMarcador() {
        String best = "";
        int maior = 0;
        int golos;
        int[] g = new int[35];
        for (int i = 0; i < Jogadores.size(); i++) {
            golos = 0;
            g = Jogadores.get(i).getGolos();
            for (int j = 0; j < g.length; j++) {
                golos += g[j];
            }
            if (golos > maior) {
                maior = golos;
                best = Jogadores.get(i).getNome();
            }
        }
        return best;
    }

    public String toString() {
        String s = "Nome equipa: " + nome;
        for (int i = 0; i < Jogadores.size(); i++) {
            s += "\nJogador: " + Jogadores.get(i).getNome();
        }
        return s;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Equipa e = (Equipa) o;
            return (this.nome == e.nome && this.Jogadores.equals(e.Jogadores));
        } else {
            return false;
        }

    }

    public Object clone() {
        Equipa e = new Equipa(this.nome);
        for (int i = 0; i < Jogadores.size(); i++) {
            e.Jogadores.add(this.Jogadores.get(i));

        }
        return e;
    }

}
