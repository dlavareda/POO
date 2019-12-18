/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.io.Serializable;

/**
 *
 * @author pacjt
 */
public class Clientes extends Pessoas implements Serializable {

    private boolean lugaradpt; //true / false
    private boolean estudante; //true / false

    public Clientes() {

    }

    public Clientes(Pessoas P) {
        super(P.getNome(), P.getDtNascimento(), P.getNif());
    }

    public Clientes(Pessoas P, boolean lugardpt, boolean estudante) {
        super(P.getNome(), P.getDtNascimento(), P.getNif());
        this.lugaradpt = lugardpt;
        this.estudante = estudante;
    }

    public boolean getLugaradpt() {
        return lugaradpt;
    }

    public void setLugaradpt(boolean lugaradpt) {
        this.lugaradpt = lugaradpt;
    }

    public boolean getEstudante() {
        return estudante;
    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }

    @Override
    public String toString() {
        return "##########################\nNome = " + this.getNome() + "\nNIF = " + this.getNif() + "\nData Nascimento = " + this.getDtNascimento() + "\nLugar Adaptado = " + lugaradpt + "\nEstudante = " + estudante + "\n##########################";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            final Clientes other = (obj != null) ? (Clientes) obj : null;         // If obj isn't null, is declared as class Clientes, else null
            return (this == obj) ? true : (this.getNome() == other.getNome()
                    && this.getDtNascimento() == other.getDtNascimento()
                    && this.getNif() == other.getNif()
                    && this.lugaradpt == other.lugaradpt
                    && this.estudante == other.estudante);
        }
        return false;
    }
}
