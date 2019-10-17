/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author dlavareda
 */
public class Aluno {

    private static int ultimo = 0;
    private int numero;
    private String nome;
    private Disciplina[] lista;

    public Aluno(String nome) {
        ultimo++;
        numero = ultimo;
        this.nome = nome;
        lista = new Disciplina[5];
        for (int i = 0; i < 5; i++) {
            lista[i].setNome("");
            lista[i].setCodigo(0);
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Disciplina[] getDisciplinas() {
        return lista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDisciplinas(Disciplina[] disciplina) {
        for (int i = 0; i < 5; i++) {
            lista[i].setCodigo(disciplina[i].getCodigo());
            lista[i].setNome(disciplina[i].getNome());
        }

    }

    public void adicionarDisciplina(Disciplina d, int p) {
        lista[p].setCodigo(d.getCodigo());
        lista[p].setNome(d.getNome());
    }

    public String toString() {
        String s = "Numero: " + numero + "\nNome: " + nome + "\n";
        for (int i = 0; i < 5; i++) {
            s += "Disciplina: " + lista[i].getCodigo() + " - " + lista[i].getNome();
        }
        return s;
    }
}
