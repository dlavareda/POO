/*
b) Construa um programa que permita “gerir” os empregados de uma empresa.
Para isso deverá armazenar os empregado num objecto do tipo
ArrayList<Empregado>.
Deverá ter as opções:
1 – Criar empregado;
2 – Consultar todos os empregados;
3 – Modificar um empregado;
4 – Apagar um empregado.
 */
package parte2;

import java.util.ArrayList;
import myinputs.Ler;

/**
 *
 * @author dlavareda
 */
public class empGest {

    public static void main(String[] args) {
        int r;
        ArrayList<Empregado> empregados = new ArrayList<Empregado>();

        do {
            System.out.println("1 – Criar empregado");
            System.out.println("2 – Consultar todos os empregados");
            System.out.println("3 – Modificar um empregado");
            System.out.println("4 – Apagar um empregado.");
            System.out.println("5 – Sair");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println("Introduza o NSS");
                    double nss = Ler.umDouble();
                    System.out.println("Introduza o Nome");
                    String nome = Ler.umaString();
                    System.out.println("Introduza o Salario");
                    double salario = Ler.umDouble();
                    Empregado e = new Empregado(nss, nome, salario);
                    empregados.add(e);
                    break;
                case 2:
                    for (int i = 0; i < empregados.size(); i++) {
                        System.out.println(empregados.get(i).toString());
                    }
                    break;
                case 3:
                    System.out.println("Qual o NSS do Empregado a modificar?");
                    
                    break;
                case 4:
                    
                    break;
            }

        } while (r != 5);

    }
}
