package aula1;

/*
2 – Conversão entre tipos
É possível converter um dado tipo num outro compatível (!) usando um operador unário de
“casting”. Por exemplo:
...
int x = 2;
float f;
f = (float) x; (converte o valor inteiro de x no real 2.0.)
...
char c=’A’;
int i;
i = (int) c;
- Escreva no ecrã em formato de tabela os carateres imprimíveis do código ASCII:
Inteiro ASCII
_____________________
 32 -> “espaço em branco”
 33 -> !
 …
125 -> }
126 -> ~
 */
/**
 *
 * @author dlavareda
 */
public class Exercicio2 {

    public static void main(String[] args) {
        char c;
        System.out.println("Inteiro   ASCII");
        System.out.println("_______________");
        for (int i = 32; i < 126; i++) {
            c = (char) i;
            System.out.println(i + "    -->    " + c);
        }

    }
}
