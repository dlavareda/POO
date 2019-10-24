/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1teste2016;

/**
 *
 * @author dlavareda
 */
public class testeLivro {

    public static void main(String[] args) {
        // TODO code application logic here
        Livro L1 = new Livro(100);
        L1.setNome("POO");
        L1.setPreco(45);
        String[] a = new String[1];
        a[0] = "Mário Martins";
        L1.setAutores(a);
        System.out.println(L1);
        Livro L2 = new Livro(101);
        L2.setNome("Programação");
        L1.setPreco(50);
        String[] b = new String[2];
        b[0] = "Abel Gomes";
        b[1] = "Luis Alexandre";
        L2.setAutores(b);
        System.out.println(L2);
    }

}
