/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula8;

import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class AlunoLicenciatura extends Aluno {

    private String curso;
    private ArrayList<Disciplina> disciplinas;

    public AlunoLicenciatura(Aluno A, String curso) {
        super(A.getNumero(), A.getNome());
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> d) {
        for (int i = 0; i < d.size(); i++) {
            this.disciplinas.add(i, d.get(i));
        }
    }

    /*
    f) addDisciplina - dado um objecto do tipo Disciplina deverá adicioná-lo à lista de
    disciplinas caso este não exista ainda na lista.
     */
    public void addDisciplina(Disciplina d) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).equals(d)) {
                return;
            }
        }
        disciplinas.add(d);
    }

    /*
    f) getNotaDisciplina - dado um código de disciplina deve devolver a nota da disciplina.
    Se essa disciplina não constar da lista de disciplinas do aluno de licenciatura o método
    deve devolver o valor 0.
     */
    public int getNotaDisciplina(int codigo) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getCodigo() == codigo) {
                return disciplinas.get(i).getCodigo();
            }
        }
        return 0;
    }

    /*
    g) método que calcule a média das classificações obtidas pelo aluno de licenciatura
     */
    public double mediaClassificacoes() {
        int soma = 0;
        int count = 0;
        for (int i = 0; i < disciplinas.size(); i++) {
            soma += disciplinas.get(i).getNota();
            count++;
        }
        return (double) soma / (double) count;
    }

    @Override
    public String toString() {
        String s = "Numero: " + this.getNumero() + "\nNome: " + this.getNome() + "\nCurso: " + curso;
        for (int i = 0; i < disciplinas.size(); i++) {
            s += "\nDisciplina: " + disciplinas.get(i);
        }
        return s;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            AlunoLicenciatura al = (AlunoLicenciatura) o;
            return (this.curso == al.curso && this.getNumero() == al.getNumero() && this.getNome().equals(al.getNome()) && disciplinas.equals(al.disciplinas));
        } else {
            return false;
        }

    }

    public Object clone() {
        Aluno a = new Aluno(this.getNumero(), this.getNome());
        AlunoLicenciatura d = new AlunoLicenciatura(a, this.curso);
        for (int i = 0; i < this.disciplinas.size(); i++) {
            d.disciplinas.set(i, this.disciplinas.get(i));
        }
        return d;
    }
}
