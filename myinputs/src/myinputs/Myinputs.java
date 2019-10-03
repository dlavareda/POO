/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinputs;

/**
 *
 * @author dlavareda
 */
public class Myinputs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Introduza uma string:");
        String s = Ler.umaString();
        System.out.println("A string que introduziu foi: " + s);
        System.out.println("Introduza um Inteiro:");
        int i = Ler.umInt();
        System.out.println("O inteiro que introduziu foi: " + i);
        System.out.println("Introduza um Float:");;
        float f = Ler.umFloat();
        System.out.println("O Float que introduziu foi: " + f);
        System.out.println("Introduza um Double:");
        double d = Ler.umDouble();
        System.out.println("O Double que introduziu foi: " + d);
        System.out.println("Introduza um Boolean:");
        Boolean b = Ler.umBoolean();
        System.out.println("O Boolean que introduziu foi: " + b);
        System.out.println("Introduza um Char:");
        char c = Ler.umChar();
        System.out.println("O Char que introduziu foi: " + c);
        System.out.println("Introduza um byte:");
        byte by = Ler.umByte();
        System.out.println("O Char que introduziu foi: " + by);
        System.out.println("Introduza um short:");
        short sh = Ler.umShort();
        System.out.println("O Short que introduziu foi: " + sh);
        System.out.println("Introduza um long:");
        long l = Ler.umLong();
        System.out.println("O Long que introduziu foi: " + l);
    }

}
