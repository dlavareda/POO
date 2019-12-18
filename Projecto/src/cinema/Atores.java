package cinema;

import java.io.Serializable;

public class Atores implements Serializable {
    
    public String nome;
    private static int lastid_atores; //guarda o ultimo ator na lista
    private int id; //ao criar funcionario lastid++; id = lastid;

    public Atores(String nome){
        lastid_atores    = lastid_atores + 1;
        this.id   = lastid_atores;  
        this.nome = nome;
        
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public static int getLastid() {
        return lastid_atores;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && getClass() == obj.getClass()){
            final Atores other = (obj != null) ? (Atores) obj : null; // If obj isn't null, is declared as class Atores, else null
            return (this == obj) ? true : ( this.nome.equals(other.nome));
        }
        return false;
    } 
}
