/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha.pkg3.ex5;

/**
 *
 * @author dlavareda
 */
public class Espetaculo {
    
    private String nome;
    private int capacidade;
    private int espectadores;//sempre menor = que a capacidade
    private double custo;
    
    public Espetaculo() {
        nome = "";
        capacidade = 0;
        espectadores = 0;
        custo = 0.0;
    }
    
    public Espetaculo(String nome, int capacidade, double custo) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.custo = custo;
    }
    
    public String getEspetaculoNome() {
        
        return nome;
    }
    
    public int getEspetaculoCapacidade() {
        return capacidade;
    }
    
    public int getEspetaculoEspectadores() {
        return espectadores;
    }
    
    public double getEspetaculosCusto() {
        return custo;
    }
    
    public void setEspetaculoNome(String nome) {
        this.nome = nome;
    }
    
    public void setEspetaculoCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public void setEspetaculoEspectadores(int espectadores) {
        this.espectadores = espectadores;
    }
    
    public void setEspetaculoCusto(double custo) {
        this.custo = custo;
    }
    
    public String toString() {
        String s = "Nome: " + nome + "\nCapacidade:  " + capacidade + "\nEspectadores: " + espectadores + "\nCusto: " + custo + "\n";
        return s;
    }
    
    public String comprarBilhete() {
        if (espectadores < capacidade) {
            this.setEspetaculoEspectadores(this.getEspetaculoEspectadores() + 1);
            return "Tem a pagar " + custo;
            
        } else {
            return "Espetaculo Esgotado";
        }
        
    }
}
