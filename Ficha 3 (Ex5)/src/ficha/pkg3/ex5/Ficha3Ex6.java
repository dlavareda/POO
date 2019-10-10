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
public class Ficha3Ex6 {

    public static void main(String[] args) {
        Espetaculo e1 = new Espetaculo("Comédia", 10, 5.0);
        e1.setEspetaculoCapacidade(10);
        e1.setEspetaculoEspectadores(9);
        //Compra o ultimo bilhete disponivel
        System.out.println(e1.comprarBilhete());
        //Falha e informa espetaculo esgotado
        System.out.println(e1.comprarBilhete());
    }
}
