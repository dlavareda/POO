package cinema;

import java.io.Serializable;
import java.time.LocalDate;

public class Pessoas implements Serializable{
    private String nome;
    private LocalDate dtnascimento;
    private int nif;

    public Pessoas(){
        
    }
    public Pessoas(String nome, LocalDate dtnascimento, int nif){
        this.nome  = nome;
        this.dtnascimento = dtnascimento;
        this.nif   = nif;
    }
    
    
    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtnascimento;
    }

    public void setDtNascimento(LocalDate dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    @Override
    public String toString() {
        return "Pessoas{" + "nome=" + nome +
                        ", Data de nascimento =" + dtnascimento + 
                        ", nif=" + nif + '}';
    }
    
   
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && getClass() == obj.getClass()){
            final Pessoas other = (obj != null) ? (Pessoas) obj : null; // If obj isn't null, is declared as class Pessoas, else null
            return (this == obj) ? true : ( this.nome.equals(other.nome) &&
                                            this.dtnascimento == other.dtnascimento &&      
                                            this.nif   == other.nif
                                        );
        }
        return false;
    } 
    
    
    
}
