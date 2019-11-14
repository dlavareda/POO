package aula8;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dlavareda
 */
public class Base {

    protected int a;
    private int b;

    public Base(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int soma() {
        return a + b;
    }

    public int soma(int x) {
        return a + b + x;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String toString() {
        return "A: " + a + " B: " + b;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Base bas = (Base) o;
            return (this.a == bas.a && this.b == bas.b);
        } else {
            return false;
        }

    }

    public Object clone() {
        Base e = new Base(this.a, this.b);
        return e;
    }
}
