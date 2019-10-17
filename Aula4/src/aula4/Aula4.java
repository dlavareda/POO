/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author dlavareda
 * 
 */
public class Aula4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] novasCriticas = new String[3];
        CadeirasCriticas cc1 = new CadeirasCriticas("Engenharia Informática");
        CadeirasCriticas cc2 = new CadeirasCriticas("Informática WEB");
        String[] aux;
        aux = cc1.getDisciplinas();
        aux[0] = "Matemática 1";
        aux[1] = "Matemática 2";
        aux[2] = "Matemática Discreta";
        cc1.setDisciplinas(aux);
        System.out.println(cc1.toString());
        aux = cc2.getDisciplinas();
        aux[0] = "Programação 1";
        aux[1] = "Programação 2";
        aux[2] = "Matemática 1";
        cc2.setDisciplinas(aux);
        System.out.println(cc2.toString());
        aux = cc1.getDisciplinas();
        String s = aux[0];
        aux[0] = aux[1];
        aux[1] = s;
        cc1.setDisciplinas(aux);
        System.out.println(cc1.toString());
        aux = cc2.getDisciplinas();
        s = aux[0];
        aux[0] = aux[1];
        aux[1] = s;
        cc2.setDisciplinas(aux);
        System.out.println(cc2.toString());
        
        novasCriticas[0] = "aoishfasf";
        novasCriticas[1] = "asdasd";
        novasCriticas[2] = "235235g";
        
        cc1.setDisciplinas(novasCriticas);
        System.out.println(cc1.toString());
        novasCriticas[0] = "123456789";
        novasCriticas[1] = "123456789";
        novasCriticas[2] = "123456789";
        System.out.println(cc1.toString());
    }
 
    
   
    
}
