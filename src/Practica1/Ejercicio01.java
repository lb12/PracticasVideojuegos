package Practica1;

import java.util.Scanner;

public class Ejercicio01 {

    /*
     * Escribir un programa que compruebe si un numero es impar y lo indique por
     * pantalla
     */
    public static boolean comprobarNumero(int num) {
        return (num % 2) == 0;
    }

    public static void main(String[] args) {
        String numeroIntrod;
        Scanner entradaEscaner = new Scanner(System.in);

        do {
            System.out.println("Introduce un numero: ");
            numeroIntrod = entradaEscaner.nextLine();
        } while (!numeroIntrod.matches("[0-9]*"));

        if (comprobarNumero(Integer.parseInt(numeroIntrod))) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }
    }
}
