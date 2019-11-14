/*
a) Construa um método público e estático que dado um array de objectos do tipo Aluno
conte quantos desses alunos são alunos de licenciatura.
b) Construa um método público e estático que dada uma ArrayList de objectos do tipo
Aluno conte quantos desses alunos são alunos de licenciatura.
 */
package aula8;

import java.util.ArrayList;

/**
 *
 * @author dlavareda
 */
public class testeEx8 {

    ArrayList<Aluno> A;

    public int numeroAlunosLicenciatura() {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            //if (A.get(i). == "AlunoLicenciatura") { not Done YEt
          
                count++;
            //}
        }
        return count;
    }
}
