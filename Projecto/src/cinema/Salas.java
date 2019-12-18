package cinema;

import java.io.Serializable;

public class Salas implements Serializable {

    private int lugarN; //lugares normais
    private int lugarA; //lugares adaptados
    private static int lastid_salas; //guarda o ultimo filme na lista
    private int id; //ao criar funcionario lastid++; id = lastid;
    private boolean disponivel; //true / false
    private boolean s3d; //true / false
    private double custohora;

    public Salas() {

    }

    public Salas(int lastid, int lugarN, int lugarA, boolean disponivel, boolean s3d, double custohora) {
        this.lugarN = lugarN;
        this.lugarA = lugarA;
        lastid_salas = lastid;
        this.id = lastid_salas;
        this.disponivel = disponivel;
        this.s3d = s3d;
        this.custohora = custohora;
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

    public static int getLastid() {
        return lastid_salas;
    }

    public static void setLastid(int lastid) {
        Salas.lastid_salas = lastid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean getS3d() {
        return s3d;
    }

    public void setS3d(boolean s3d) {
        this.s3d = s3d;
    }

    public double getCustoHora() {
        return custohora;
    }

    public void setCustoHora(double custohora) {
        this.custohora = custohora;
    }

    @Override
    public String toString() {
        return "##########################\nSala " + id + "\nLugares Normais = " + lugarN + "\nLugares Adaptados = " + lugarA + "\nDisponivel = " + disponivel + "\nSala 3D = " + s3d + "\nCusto por hora = " + custohora + "\n##########################";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            final Salas other = (obj != null) ? (Salas) obj : null; // If obj isn't null, is declared as class Sala, else null
            return (this == obj) ? true : (this.lugarN == other.lugarN
                    && this.lugarA == other.lugarA
                    && this.disponivel == other.disponivel
                    && this.s3d == other.s3d
                    && this.id == other.id
                    && this.custohora == other.custohora);
        }
        return false;
    }

}
