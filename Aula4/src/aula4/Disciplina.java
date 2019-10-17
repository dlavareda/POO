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
public class Disciplina {

    private int codigo;
    private String nome;

    public Disciplina() {
        codigo = 0;
        nome = "";
    }

    public Disciplina(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String toString() {
        return "Codigo: " + codigo + " Nome: " + nome + "\n";
    }
}
