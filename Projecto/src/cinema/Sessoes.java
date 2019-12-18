package cinema;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Sessoes implements Serializable{
    private static int lastid; //guarda a ultima sessao na lista
    private int id; //ao criar funcionario lastid++; id = lastid;
    private int sala;
    private LocalDateTime datahora;
    private int filme;
    private int lugarN; //lugares normais
    private int lugarA; //lugares adaptados
    private double lucro; //montante menos (o custo da sala por hora vezes a duracao do filme) M - (C x D)
    private double montante; //soma dos bilhetes vendidos nesta sessao
     
    public Sessoes(){
        
    }
    
     public Sessoes( int sala, LocalDateTime datahora, int dia, int mes, int ano, int filme, int lugarN, int lugarA, double lucro, double montante) {
        lastid        = lastid +1;
        this.id       = lastid;
        this.sala     = sala;
        this.datahora = datahora;
        this.filme    = filme;
        this.lugarN   = lugarN;
        this.lugarA   = lugarA;
        this.lucro    = lucro;
        this.montante = montante;
    }

    public static int getLastid() {
        return lastid;
    }

    public static void setLastid(int lastid) {
        Sessoes.lastid = lastid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public LocalDateTime getDataHora() {
        return datahora;
    }
    
    public void setDataHora(LocalDateTime datahora){
        this.datahora = datahora;
    }
   
    public int getFilme() {
        return filme;
    }

    public void setFilme(int filme) {
        this.filme = filme;
    }

    public int getLugarN() {
        return lugarN;
    }

    public void setLugarN(int lugarN) {
        this.lugarN = lugarN;
    }

    public int getLugarA() {
        return lugarA;
    }

    public void setLugarA(int lugarA) {
        this.lugarA = lugarA;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    @Override
    public String toString() {
        return "Sessao{" + "id=" + id + 
                ", sala=" + sala + 
                ", datahora =" + datahora + 
                ", filme=" + filme + 
                ", lugarN=" + lugarN + 
                ", lugarA=" + lugarA + 
                ", lucro=" + lucro + 
                ", montante=" + montante + '}';
    }
    
     
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && getClass() == obj.getClass()){
            final Sessoes other = (obj != null) ? (Sessoes) obj : null;        // If obj isn't null, is declared as class Sessao, else null
            return (this == obj) ? true : ( this.sala      == other.sala        &&
                                            this.datahora      == other.datahora        &&
                                            this.filme     == other.filme       &&
                                            this.lugarA    == other.lugarA      &&
                                            this.lugarN    == other.lugarN      &&
                                            this.lucro     == other.lucro       && 
                                            this.montante  == other.montante 
                                           );
      
        } 
        return false;
    
    }
    
    
}
