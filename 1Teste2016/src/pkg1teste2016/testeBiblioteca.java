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
public class testeBiblioteca {

    public static void main(String[] args) {
        Biblioteca B = new Biblioteca();
        B.setNome("UBI");
        B.setEmail("geral@ubi.pt");
        Livro L1 = new Livro(1002);
        L1.setNome("POO");
        L1.setPreco(45);
        String[] a = new String[1];
        a[0] = "Mário Martins";
        L1.setAutores(a);
        B.addLivros(L1);
        Livro L2 = new Livro(1003);
        L2.setNome("Anita");
        L2.setPreco(15);
        String[] b = new String[2];
        b[0] = "José Figueiras";
        b[1] = "Carla Silva";
        L2.setAutores(b);
        B.addLivros(L2);       
        System.out.println(B);
        System.out.println("O livro 'Anita' existe na Biblioteca? "+B.procura("Anita"));//resultado true/false
        System.out.println("O livro 'Contos' existe na Biblioteca? "+B.procura("Contos"));//resultado true/false
        System.out.println("Valor total dos livros da bilioteca: " + B.valorTotalLivros());
    }
}
