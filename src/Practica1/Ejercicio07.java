package Practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio07 {

    /* 
     * Cree un programa que lea por teclado n�meros y muestre la media de dichos n�meros.
     * Deje de leer datos cuando el usuario introduzca un n�mero negativo
     */
    public static void main(String[] args) {

        Double sumaNumeros = 0d, numeroIntroducido = 0d; // Double para admitir numeros grandes
        int contador = 0; // Contamos cuantos numeros correctos se han introducido (media)
        Scanner teclado = new Scanner(System.in);

        while (numeroIntroducido >= 0) { // Hasta que se introduzca un numero negativo
            try {
                System.out.println("Introduce un numero. ");
                numeroIntroducido = teclado.nextDouble();
                if (numeroIntroducido >= 0) { // Si no es negativo, registramos el numero
                    sumaNumeros += numeroIntroducido;
                    contador++;
                }
            } catch (InputMismatchException ex) { // Posible excepcion (entradas != a numeros)
                System.out.println("Solo debes introducir numeros.");
                System.out.println(teclado.next() + " no es un numero.");
            }
        }
        System.out.println("El total de numeros introducidos ha sido '" + contador + "' y la media total equivale a "
                + (sumaNumeros / contador)); // Mensaje final
    }
}
