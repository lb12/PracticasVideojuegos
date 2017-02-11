package Practica1;

public class Ejercicio02 {

    /*
     * Escribir un programa que muestre por pantalla la suma de los cien
     * primeros numeros enteros empezando en el 1.
     */

    public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i <= 100; i++) {
            suma += i;
            System.out.println(suma);
        }
    }
}
