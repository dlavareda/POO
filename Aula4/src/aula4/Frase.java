/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

import java.util.Scanner;

/**
 *
 * @author dlavareda
 */
public class Frase {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, p = 0, q = 0, r = 0, s = 0, t = 0, u = 0, v = 0, w = 0, x = 0, y = 0, z = 0;
        String str = "The competent programmer is fully aware of the limited size of his own skull. He therefore approaches his task with full humility, and avoids clever tricks like the plague.";
        int comespacos = str.length();
        System.out.println("Numero de caracteres = " + comespacos);
        int semespacos = str.replace(" ", "").length();
        System.out.println("Numero de caracteres (sem espaços) = " + semespacos);
        System.out.println("Numero de palavras = " + (comespacos - semespacos + 1));
        for (int ii = 0; ii < str.length(); ii++) {
            str = str.toLowerCase();
            char ch = str.charAt(ii);
            switch (ch) {
                case 'a':
                    a++;
                    break;
                case 'b':
                    b++;
                    break;
                case 'c':
                    c++;
                    break;
                case 'd':
                    d++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'f':
                    f++;
                    break;
                case 'g':
                    g++;
                    break;
                case 'h':
                    h++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'j':
                    j++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'k':
                    k++;
                    break;
                case 'm':
                    m++;
                    break;
                case 'n':
                    n++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'p':
                    p++;
                    break;
                case 'q':
                    q++;
                    break;
                case 'r':
                    r++;
                    break;
                case 's':
                    s++;
                    break;
                case 't':
                    t++;
                    break;
                case 'u':
                    u++;
                    break;
                case 'v':
                    v++;
                    break;
                case 'x':
                    x++;
                    break;
                case 'w':
                    w++;
                    break;
                case 'y':
                    y++;
                    break;
                case 'z':
                    z++;
                    break;
            }
        }
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
        System.out.println("E: " + e);
        System.out.println("F: " + f);
        System.out.println("G: " + g);
        System.out.println("H: " + h);
        System.out.println("I: " + i);
        System.out.println("J: " + j);
        System.out.println("K: " + k);
        System.out.println("L: " + l);
        System.out.println("M: " + m);
        System.out.println("N: " + n);
        System.out.println("O: " + o);
        System.out.println("P: " + p);
        System.out.println("Q: " + q);
        System.out.println("R: " + r);
        System.out.println("S: " + s);
        System.out.println("T: " + t);
        System.out.println("U: " + u);
        System.out.println("V: " + v);
        System.out.println("W: " + w);
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("Z: " + z);

        System.out.println("Introduza uma palavra a pesquisar na frase.");

        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();

        System.out.println(str.indexOf(search));

    }
}
