/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.*;
import java.util.*;

/**
 *
 * @author dlavareda
 */
public class files {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<String>();
        lista.add("um");
        lista.add("dois");
        lista.add("três");
        lista.add("quatro");
        // Escrever um objeto para um ficheiro
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/home/dlavareda/Documents/UBI/2019-2020/POO/POO/Aula7/ficheiroExemplo.dat"));
            // escrever o objeto lista no ficheiro
            os.writeObject(lista);
            os.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Ler um objeto de um ficheiro
        ArrayList<String> lista2 = new ArrayList<String>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("/home/dlavareda/Documents/UBI/2019-2020/POO/POO/Aula7/ficheiroExemplo.dat"));
            lista2 = (ArrayList) is.readObject();
            System.out.println(lista2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
