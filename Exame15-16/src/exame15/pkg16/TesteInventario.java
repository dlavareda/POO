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
public class TesteInventario {

    public static void main(String[] args) {
        Produto p1 = new Produto("Portatil ASUS");
        p1.setPreco(600);
        Produto p2 = new Produto("Portatil HP");
        p2.setPreco(800);
        ArrayList<Produto> p = new ArrayList<Produto>();
        p.add(p1);
        p.add(p2);
        LocalDate dt_val = null;
        dt_val = of(2019, 12, 11);
        ProdutoAlimentar pa1 = new ProdutoAlimentar(p1, dt_val);
        dt_val = of(2019, 12, 25);
        ProdutoAlimentar pa2 = new ProdutoAlimentar(p1, dt_val);
        p.add(pa1);
        p.add(pa2);
        Inventario i = new Inventario(p);
        
        System.out.println("Total Fora Prazo: " + i.totalForaPrazo());
    }
}
