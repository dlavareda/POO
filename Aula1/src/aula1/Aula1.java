/*
1 – Operadores
- Construa um programa onde use e teste cada um dos seguintes operadores:
- aritméticos:+, -, *, /, %
- incremento e decremento: ++, --
(qual a diferença entre i2=i1++ e i2=++i1 ? )
- operadores de atribuição: +=, -=, *=, /=, %=
 */
package aula1;

/**
 *
 * @author dlavareda
 */
public class Aula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        double result = a + b;
        System.out.println(a + " + " + b + " = " + result);
        result = a - b;
        System.out.println(a + " - " + b + " = " + result);
        result = a * b;
        System.out.println(a + " * " + b + " = " + result);
        result = a / b;
        System.out.println(a + " / " + b + " = " + result);
        result = a % b;
        System.out.println(a + " % " + b + " = " + result);
        //a++
        System.out.println("a++ = " + ++a);   
        System.out.println("a-- = " + --a);   
        a += b;
        System.out.println("a += b = " + a);   
        a = 10;
        a -= b;
        System.out.println("a += b = " + a);
        a = 10;
        a -= b;
        System.out.println("a -= b = " + a);  
        a = 10;
        a *= b;
        System.out.println("a *= b = " + a);  
        a = 10;
        a /= b;
        System.out.println("a /= b = " + a); 
        a = 10;
        a %= b;
        System.out.println("a %= b = " + a);  
    }
    
}
