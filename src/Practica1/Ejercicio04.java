package Practica1;

import java.util.Scanner;

public class Ejercicio04 {

    /*
     * Escribir un programa que, dado un numero, indique el numero de bits
     * necesario para representar ese numero en binario. Por ejemplo, dado el
     * numero 3, necesitamos 2 bits para representarlo (22 = 4 > 3)
     */
    public static int calcularNumeroBits(int num) {
        int i = 1, potencia = 0;
        potencia = (int) Math.pow(2, i);
        while (potencia < num) {
            i++;
            potencia = (int) Math.pow(2, i);
        }
        return i;
    }

    public static void main(String[] args) {
        String numero;
        Scanner teclado = new Scanner(System.in);
        
        do {
            System.out.println("Introduce el numero decimal que quieras saber"
                    + " con cuantos bits se representa en binario.");
            numero = teclado.nextLine();
        } while (!numero.matches("[0-9]*"));
        System.out.println("Para representar el numero " + numero + " en binario"
                + " necesitas " + calcularNumeroBits(Integer.parseInt(numero))
                + " bits.");
    }
}
