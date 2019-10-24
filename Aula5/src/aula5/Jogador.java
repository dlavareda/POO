package aula5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dlavareda
 */
public class Jogador {

    private String nome;
    private double salario;
    private int[] golos;//array 34 pos

    /*A classe deverá ter dois construtores, um com o parâmetro nome e outro com os parâmetros
nome e salário*/
    public Jogador(String nome) {
        this.nome = nome;
        salario = 0;
        golos = new int[35];
        for (int i = 0; i < 34; i++) {
            golos[i] = 0;
        }
    }

    public Jogador(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
        golos = new int[35];
        for (int i = 0; i < 34; i++) {
            golos[i] = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int[] getGolos() {
        int[] g;
        g = new int[35];
        for (int i = 0; i < golos.length; i++) {
            g[i] = this.golos[i];
        }
        return g;
    }

    public void setGolos(int[] golos) {
        for (int i = 0; i < golos.length; i++) {
            this.golos[i] = golos[i];
        }
    }

    public void aumentarSalario(double percent) {
        salario = salario + salario * (percent / 100);
    }

    public void setGolosJornada(int ngolos, int jornada) {
        jornada--;//porque a primeira jornada é a 1 e o primeiro elemento do array é 0
        this.golos[jornada] = ngolos;

    }

    public int getGolosJornada(int jornada) {
        jornada--;//porque a primeira jornada é a 1 e o primeiro elemento do array é 0
        return this.golos[jornada];
    }

    public String toString() {
        String s = "Nome: " + nome + " Salário: " + salario + "\n";
        for (int i = 0; i < 34; i++) {
            s += " Jornada " + (i+1) + " golos: " + golos[i] + "\n";
        }
        return s;
    }
}
