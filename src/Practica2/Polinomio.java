package Practica2;

import java.text.DecimalFormat;

/**
 * Clase para el ejercicio 2
 */
public class Polinomio {

    private double a, b, c, d;
    DecimalFormat df = new DecimalFormat("###,###.##"); //Formatear rdo

    public Polinomio(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setD(double d) {
        this.d = d;
    }

    public String compute(double x) { //f(x) = ax^3 + bx^2 + cx + d 
        return df.format((a * potencia(x, 3)) + (b * potencia(x, 2)) + (c * x) + d);
    }

    public String mostrarPolinomio() {
        return "f(x) = " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d;
    }

    private double potencia(double x, int exp) {
        return Math.pow(x, exp);
    }
}
