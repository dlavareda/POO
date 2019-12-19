/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exame15.pkg16;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author dlavareda
 */
public class ProdutoAlimentar extends Produto {

    private LocalDate dataValidade;

    public ProdutoAlimentar(Produto p, LocalDate dt_validade) {
        super(p.getNome());
        this.setQuantidade(p.getQuantidade());
        this.setPreco(p.getPreco());
        dataValidade = dt_validade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            ProdutoAlimentar p = (ProdutoAlimentar) obj;
            return (this.getNome().equals(p.getNome()) && this.getCodigo() == p.getCodigo() && this.getQuantidade() == p.getQuantidade() && this.getPreco() == p.getPreco() && this.dataValidade.isEqual(p.dataValidade));
        }
        return false;
    }
    
   
}
