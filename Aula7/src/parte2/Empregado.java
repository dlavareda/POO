/*
Exercícios:
1 – Construa uma classe que represente os Empregados de uma empresa. Um Empregado
tem um número de segurança social, um nome e um salário. Defina os atributos, dois
construtores à sua escolha, os métodos de consulta (getters) e os de modificação
(setters), e o método toString. Construa ainda um método que permita subir o salário do
empregado de uma dada percentagem dada como parâmetro.
2 – Construa uma classe de teste que permita verificar todos os métodos da classe
Empregado 
 */
package parte2;

/**
 *
 * @author dlavareda
 */
public class Empregado {

    private int NSS;
    private String nome;
    private double salario;

    public Empregado(int NSS, String nome) {
        this.NSS = NSS;
        this.nome = nome;
    }

    public Empregado(int NSS, String nome, double salario) {
        this.NSS = NSS;
        this.nome = nome;
        this.salario = salario;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getNSS() {
        return NSS;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void subirSalario(int percent) {
        salario = salario + salario * (percent / 100);
    }

    public String toString() {
        return "NSS: " + NSS + "\nNome: " + nome + "\nSalario: " + salario;
    }
    
     public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Empregado e = (Empregado) o;
            return (this.NSS == e.NSS && this.nome.equalsIgnoreCase(e.getNome()) && this.salario == e.salario);
        } else {
            return false;
        }

    }

    public Object clone() {
        Empregado e = new Empregado(this.NSS, this.nome, this.salario);
        return e;
    }

}
