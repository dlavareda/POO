/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 */
public class CadeirasCriticas {

    private String nomeCurso;
    private String[] disciplinas;

    public CadeirasCriticas(String nome) {
        nomeCurso = nome;
        disciplinas = new String[3];
        for (int i = 0; i < 3; i++) {
            disciplinas[i] = "";
        }
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String[] getDisciplinas() {
        return disciplinas;
    }

    public void setNomeCurso(String nome) {
        nomeCurso = nome;
    }

    public void setDisciplinas(String[] disciplinas) {
        for (int i = 0; i < 3; i++) {
            this.disciplinas[i] = disciplinas[i];
        }
        
    }

    public String toString() {
        String s = "Nome Curso: " + nomeCurso;
        for (int i = 0; i < 3; i++) {
            s += "\nDisciplina: " + disciplinas[i];
        }
        return s + "\n";
       
    }

}
