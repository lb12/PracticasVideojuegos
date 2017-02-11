package Practica1;

import java.util.Scanner;

public class Ejercicio03 {

    /* Escribir un programa que calcule el factorial de un numero */
    public static int calcularFactorial(int num) {
        int factorial = num;
        while (num > 1) {
            factorial = factorial * (num - 1);
            num--;
        }
        return factorial;
    }

    public static void main(String[] args) {
        String numero;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Introduce el numero a obtener su factorial");
            numero = teclado.nextLine();
        } while (!numero.matches("[0-9]*"));
        System.out.println(numero + "! = " + calcularFactorial(Integer.parseInt(numero)));
    }
}
