/*
2 - Defina uma classe, Derivada, como subclasse da classe Base. Na subclasse
Derivada, defina um atributo a do tipo int, um atributo c do tipo int, e um
construtor com a assinatura Derivada (Base b, int a, int c).
- Na subclasse Derivada construa ainda os seguintes métodos:
a) Getters e setters;
b) Método toString.
c) Método que calcule a soma de todas as variáveis de instância de um objeto
da classe Derivada.
d) Método equals.
e) Método clone.
 */
package aula8;

/**
 *
 * @author dlavareda
 */
public class Derivada extends Base {

    private int a;
    private int c;

    public Derivada(Base b, int a, int c) {
        super(b.getA(), b.getB());
        this.a = a;
        this.c = c;
    }

    public int getALocal() {
        return this.a;
    }

    public int getC() {
        return this.c;
    }

    public void setALocal(int a) {
        this.a = a;
    }

    public void setCLocal(int c) {
        this.c = c;
    }

    public String toString() {
        return "Derivada A: " + a + " Base a: " + super.getA() + " Base b: " + super.getB() + " Derivada C: " + c;
    }

    public int soma() {
        int soma = a + super.getA() + super.getB() + c;

        return a;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Derivada d = (Derivada) o;
            return (this.a == d.a && this.c == d.c && this.getA() == d.getA() && this.getB() == d.getB());
        } else {
            return false;
        }

    }

    public Object clone() {
        Base b = new Base(this.getA(), this.getB());
        Derivada d = new Derivada(b, this.a, this.c);
        return d;
    }

}
