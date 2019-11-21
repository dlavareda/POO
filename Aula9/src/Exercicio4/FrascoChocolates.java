/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio4;

/**
 *
 * @author dlavareda
 */
public class FrascoChocolates {

    int capacidade, conteudo;

    public FrascoChocolates(int cap, int cont) {
        capacidade = cap;
        conteudo = cont;
    }

    public void retira(int qtd) throws FrascoVazio {

        if (conteudo - qtd < 0) {
            throw new FrascoVazio("OH! OH! guloso, queres demais " + qtd + " " + conteudo);

        } else {
            conteudo -= qtd;
        }

    }

    public void enche(int qtd) throws FrascoCheio {

        if (conteudo + qtd > capacidade) {
            throw new FrascoCheio("OH! OH! já chega, estou de dieta " + qtd + " " + conteudo);
        } else {
            conteudo += qtd;
        }

    }
}
