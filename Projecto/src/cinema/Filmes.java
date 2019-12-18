/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Filmes implements Serializable {

    private String nome;
    private static int lastid_filmes; //guarda o ultimo filme na lista
    private int id; //ao criar funcionario lastid++; id = lastid;
    private String genero;
    private int rating; //idade minima
    private double duracao;
    private LocalDate datain; //entrada
    private LocalDate dataout; //saida   //objeto tipo data ou ter um int para o dia, para o mes ou para o ano
    private String sinopse;
    private ArrayList<Atores> atores;
    private ArrayList<Realizadores> realizadores;
    private ArrayList<Sessoes> sessao;

    public Filmes() {
        lastid_filmes = lastid_filmes + 1;
        this.id = lastid_filmes;
    }

    public Filmes(String nome) {
        lastid_filmes = lastid_filmes + 1;
        this.id = lastid_filmes;
        this.nome = nome;
        this.nome = nome;
        this.rating = 0;
        this.duracao = 0.0;
        this.datain = LocalDate.MIN;
        this.dataout = LocalDate.MAX;
        this.sinopse = "";
        this.atores = new ArrayList<Atores>();
        this.realizadores = new ArrayList<Realizadores>();
        this.sessao = new ArrayList<Sessoes>();
    }

    public Filmes(String nome, int rating, double duracao, LocalDate datain, LocalDate dataout, String sinopse, ArrayList<Atores> atores, ArrayList<Realizadores> realizadores, ArrayList<Sessoes> sessao) {
        this.nome = nome;
        this.rating = rating;
        this.duracao = duracao;
        this.datain = datain;
        this.dataout = dataout;
        this.sinopse = sinopse;
        this.atores = atores;
        this.realizadores = realizadores;
        this.sessao = sessao;
        lastid_filmes = lastid_filmes + 1;
        this.id = lastid_filmes;
    }

    public String getNome() {
        return nome;
    }

    public static int getLastid() {
        return lastid_filmes;
    }

    public int getId() {
        return id;
    }

    public String getGenero() {
        return genero;
    }

    public int getRating() {
        return rating;
    }

    public double getDuracao() {
        return duracao;
    }

    public LocalDate getDatain() {
        return datain;
    }

    public LocalDate getDataout() {
        return dataout;
    }

    public String getSinopse() {
        return sinopse;
    }

    public ArrayList<Atores> getAtores() {
        return atores;
    }

    public ArrayList<Realizadores> getRealizadores() {
        return realizadores;
    }

    public ArrayList<Sessoes> getSessao() {
        return sessao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void setLastid(int lastid) {
        Filmes.lastid_filmes = lastid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setDatain(LocalDate datain) {
        this.datain = datain;
    }

    public void setDataout(LocalDate dataout) {
        this.dataout = dataout;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setAtores(ArrayList<Atores> atores) {
        this.atores = atores;
    }

    public void setRealizadores(ArrayList<Realizadores> realizadores) {
        this.realizadores = realizadores;
    }

    public void setSessao(ArrayList<Sessoes> sessao) {
        this.sessao = sessao;
    }

    @Override
    public String toString() {
        String res = "##########################\nID=" + id
                + "\nNome =" + nome
                + "\nGenero = " + genero
                + "\nRating = " + rating
                + "\nDuracao = " + duracao
                + "\nData Entrada em Exibição = " + datain
                + "\nData Saida de Exibição = " + dataout;

        res += "\nAtores = ";
        for (int i = 0; i < atores.size(); i++) {
            res += atores.get(i).toString() + ((i < atores.size() - 1) ? ", " : "");
        }

        res += "\nRealizadores = ";
        for (int i = 0; i < realizadores.size(); i++) {
            res += realizadores.get(i).toString() + ((i < realizadores.size() - 1) ? ", " : "");
        }

        res += "\nSessões = ";
        for (int i = 0; i < sessao.size(); i++) {
            res += sessao.get(i).toString() + ((i < sessao.size() - 1) ? ", " : "");
        }
        res += "\n##########################";
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            final Filmes other = (obj != null) ? (Filmes) obj : null;        // If obj isn't null, is declared as class Atores, else null
            return (this == obj) ? true : (this.nome.equals(other.nome)
                    && this.rating == other.rating
                    && this.duracao == other.duracao
                    && this.datain == other.datain
                    && this.dataout == other.dataout
                    && this.id == other.id
                    && this.sinopse.equals(other.sinopse)
                    && this.atores.equals(other.atores)
                    && this.realizadores.equals(other.realizadores)
                    && this.sessao.equals(other.sessao));

        }
        return false;

    }

}
