/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1teste2017;

import java.time.LocalDate;

/**
 *
 * @author dlavareda
 */
public class Frequencia {

    private String disciplina;
    private LocalDate data;
    private Pergunta[] perguntas;

    public Frequencia(String nome, int nperguntas) {
        disciplina = nome;
        data = LocalDate.now();
        perguntas = new Pergunta[nperguntas];
        for (int i = 0; i < nperguntas; i++) {
            perguntas[i] = new Pergunta();
        }
    }

    public Pergunta[] getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Pergunta[] p) {
        for (int i = 0; i < p.length; i++) {
            perguntas[i].setNumero(p[i].getNumero());
            perguntas[i].setTexto(p[i].getTexto());
            perguntas[i].setValor(p[i].getValor());
        }
    }

    public String toString() {
        String S = "Disciplon: " + disciplina + "\nData: " + data;
        for (int i = 0; i < perguntas.length; i++) {
            S += "\nPergunta " + (i + 1) + " : " + perguntas[i].toString();

        }
        return S;
    }

    public double somaCotacoesTeste() {
        double soma = 0;
        for (int i = 0; i < perguntas.length; i++) {
            soma += perguntas[i].getValor();
        }
        return soma;
    }
}
