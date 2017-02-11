package Practica1;

import java.util.Scanner;

public class Ejercicio11 {

    /* Utilice los ejercicios 9 y 10 para implementar el mismo juego, 
     * pero permitiendo al jugador elegir qué rol quiere desempeñar 
     * en el juego
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String rolJugado;
        do {
            System.out.println("Que rol quieres jugar?");
            System.out.println("1. Quiero adivinar un numero pensado por la maquina."); //Ejercicio 9
            System.out.println("2. Quiero que la maquina adivine un numero que yo piense."); //Ejercicio 10
            rolJugado = teclado.nextLine();
            if (!rolJugado.matches("[1-2]")) { //Mostrar mensaje en caso de error.
                System.out.println("Te has equivocado y no ha seleccionado una opción correcta. Intentalo de nuevo.");
            }
        } while (!rolJugado.matches("[1-2]")); //Bucle en caso de que no se meta una opcion correcta.
        
        //Nos ponemos a jugar segun el ejercicio que se haya seleccionado.
        if (rolJugado.equals("1")) {
            Ejercicio09.jugar();
        } else {
            Ejercicio10.jugar();
        }
    }
}
