/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exame15.pkg16;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class Inventario {

    private ArrayList<Produto> produtos;

    public Inventario() {
        this.produtos = new ArrayList<>();
    }

    public Inventario(ArrayList<Produto> p) {
        this.produtos = p;
    }

    public int totalForaPrazo() {
        int count = 0;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof ProdutoAlimentar) {
                if (((ProdutoAlimentar) produtos.get(i)).getDataValidade().compareTo(LocalDate.now()) < 0) {
                    count++;
                }
            }

        }
        return count;
    }
}
