/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula8;

/**
 *
 * @author dlavareda
 */
public class Disciplina {

    private int codigo;
    private String designacao;
    private int nota;

    public Disciplina(int codigo, String designacao) {
        this.codigo = codigo;
        this.designacao = designacao;
        this.nota = 0;
    }

    public Disciplina(Disciplina d) {
        this.codigo = d.codigo;
        this.designacao = d.designacao;
        this.nota = d.nota;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", designacao=" + designacao + ", nota=" + nota + '}';
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Disciplina d = (Disciplina) o;
            return (this.codigo == d.codigo && this.designacao.equals(d.designacao) && this.nota == d.nota);
        } else {
            return false;
        }

    }

    public Object clone() {
        Disciplina d = new Disciplina(this.codigo, this.designacao);
        d.setNota(this.nota);
        return d;
    }

}
