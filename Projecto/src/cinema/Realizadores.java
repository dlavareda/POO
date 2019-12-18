package cinema;

import java.io.Serializable;

public class Realizadores implements Serializable {

    private String nome;
    private static int lastid_realizadores; //guarda o ultimo realizador na lista
    private int id; //ao criar funcionario lastid++; id = lastid;

    public Realizadores() {
    }

    public Realizadores(String nome) {

        lastid_realizadores = lastid_realizadores + 1;
        this.id = lastid_realizadores;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static int getLastid() {
        return lastid_realizadores;
    }

    public static void setLastid(int lastid) {
        Realizadores.lastid_realizadores = lastid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            final Realizadores other = (obj != null) ? (Realizadores) obj : null; // If obj isn't null, is declared as class Realizadores, else null
            return (this == obj) ? true : (this.nome.equals(other.nome));
        }
        return false;
    }

}
