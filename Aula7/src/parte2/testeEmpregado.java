/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

/**
 *
 * @author dlavareda
 */
public class testeEmpregado {
    
    public static void main(String[] args){
        Empregado E1 = new Empregado(123456,"Diogo", 1500);
        System.out.println(E1);
        E1.subirSalario(10);
        System.out.println(E1);
    }
}
