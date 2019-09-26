/*
3 - Ler um caráter do teclado
O método System.in.read() permite ler dados a partir de um buffer associado ao teclado
 */
package aula1;

/**
 *
 * @author dlavareda
 */
class LerCarater {

    public static void main(String[] args) throws java.io.IOException //!!!!
    {
        char c;
        int i;
        System.out.print("Introduza um caráter pelo teclado: ");
        i = System.in.read();
        System.out.println("O código ASII do caráter que introduziu é : " + i);
        c = (char) i;
        System.out.println("O caráter que introduziu foi: " + c);
    }
}
