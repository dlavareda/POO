/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exame15.pkg16;

import java.time.LocalDate;
import static java.time.LocalDate.of;
import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class TesteProduto {

    public static void main(String[] args) {
        Produto p1 = new Produto("Portatil ASUS");
        p1.setPreco(600);
        System.out.println(p1);
        Produto p2 = new Produto("Portatil HP");
        p2.setPreco(800);
        System.out.println(p2);
        try {
            p2.subirProduto(15);
        } catch (ValorInvalido e) {
            System.out.println(e.getMessage());
        }
        System.out.println(p2);
        ArrayList<Produto> p = new ArrayList<Produto>();
        p.add(p1);
        p.add(p2);
        p.add(p2);
        System.out.println(Produto.nomeProdutoMaisCaro(p));
        System.out.println("Numero de elementos Portatil ASUS: " + Produto.numeroProdutoByNome(p, "Portatil ASUS"));
        System.out.println("Numero de elementos Portatil HP: " + Produto.numeroProdutoByNome(p, "Portatil HP"));
        System.out.println("P1 == P2");
        System.out.println(p1.equals(p2));
        System.out.println("P2 == P2");
        System.out.println(p2.equals(p2));

    }

}
