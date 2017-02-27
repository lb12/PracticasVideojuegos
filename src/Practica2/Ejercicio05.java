package Practica2;

/**
 * Repetir el ejercicio 3 usando una interfaz que contenga las funciones de la
 * calculadora e implementar dicha interfaz en una clase.
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        CalculadoraInterface calc = new CalculadoraVersionNueva();

        System.out.println("4 + 5 = " + calc.suma(4, 5));
        System.out.println("4.3265 - 10.2457 = " + calc.resta(4.3265, 10.2457));
        System.out.println("36541.325 / 123.00002211 = " + calc.division(36541.325, 123.00002211));
        System.out.println("12 / 0 = " + calc.division(12, 0));
        System.out.println("23.6521 * pi = " + calc.multiplicacion(23.6521, Math.PI));
    }
}

/**
 * Con el uso de la interfaz, el cliente solo trata con la interface y no con la
 * implementacion por lo que es una buena manera de separar la implementacion
 * del cliente. (Abstraccion)
 */
