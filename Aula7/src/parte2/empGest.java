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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        //Carrega os dados do ficheiro
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("/home/dlavareda/Documents/UBI/2019-2020/POO/POO/Aula7/empregadosDB.dat"));
            empregados = (ArrayList) is.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

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
                    int nss = Ler.umInt();
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
                    int editar = Ler.umInt();
                    for (int i = 0; i < empregados.size(); i++) {
                        if (empregados.get(i).getNSS() == editar) {
                            System.out.println("Introduza o novo nome");
                            empregados.get(i).setNome(Ler.umaString());
                            System.out.println("Introduza o novo salário");
                            empregados.get(i).setSalario(Ler.umDouble());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Qual o NSS do Empregado a apagar?");
                    int apagar = Ler.umInt();
                    for (int i = 0; i < empregados.size(); i++) {
                        if (empregados.get(i).getNSS() == apagar) {
                            empregados.remove(i);
                        }
                    }
                    break;
            }

        } while (r != 5);
        //grava o ArrayList no ficheiro antes de sair
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/home/dlavareda/Documents/UBI/2019-2020/POO/POO/Aula7/empregadosDB.dat"));
            // escrever o objeto lista no ficheiro
            os.writeObject(empregados);
            os.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
