/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula8;

/**
 *
 * @author dlavareda
 */
public class testeBase {

    public static void main(String[] args) {
        Base b1 = new Base(2, 4);
        System.out.println(b1);
        b1.setA(8);
        System.out.println(b1);
        Base b2 = new Base(8,4);
        System.out.println(b1.equals(b2));
        b2.setB(8);
        System.out.println(b1.equals(b2));
        System.out.println(b1.soma());
    }
}
