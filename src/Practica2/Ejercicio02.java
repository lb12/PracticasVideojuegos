package Practica2;

/**
 * Cree una clase Polinomio que implemente el siguiente polinomio: f(x) = ax3 +
 * bx2 + cx + d (1) Con los atributos a, b, c y d, de tipo double, y los métodos
 * siguientes: 1. public void setA(double a): Establece el valor del coeficiente
 * a. 2. public void setB(double b): Establece el valor del coeficiente b. 3.
 * public void setC(double c): Establece el valor del coeficiente c. 4. public
 * void setD(double d): Establece el valor del coeficiente d. 5. public void
 * setABCD(double a, double b, double c, double d): Establece el valor de los
 * coeficientes a, b, c y d. 6. public double compute(double x): Calcular el
 * valor del polinomio para la x dada.
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        Polinomio p1 = new Polinomio(3, 2, 1, 0.5);
        Polinomio p2 = new Polinomio(0.5, 1, 2, 3);
        double x;

        //Polinomio 1
        System.out.println(p1.mostrarPolinomio());
        x = 4.6;
        System.out.println("Para una \"x\" = " + x + ", el resultado es " + p1.compute(x));

        //Polinomio 2
        System.out.println(p2.mostrarPolinomio());
        x = 6.4;
        System.out.println("Para una \"x\" = " + x + ", el resultado es " + p2.compute(x));
    }

}
