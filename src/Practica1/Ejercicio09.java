package Practica1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio09 {

    /*
	 * Implemente un juego con dos jugadores, en el que uno debe elegir un
	 * numero entre el 1 y el 100, y el otro debe adivinarlo realizando el menor
	 * numero posible de preguntas preguntas. La unica pregunta que puede
	 * realizarse es si el numero elegido es menor que otro. El jugador humano
	 * es quien realiza las preguntas y el ordenador escoger un numero y
	 * contestarlas
     */
    // Metodo el cual genera el menu para pedir el nivel de dificultad
    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        String respuesta = "";

        do {
            System.out.println("Introduce el grado de dificultad en el que quieras jugar.");
            System.out.println("1. Nivel Facil");
            System.out.println("2. Nivel Medio");
            System.out.println("3. Nivel Dificil");

            respuesta = teclado.next(); // Evitamos excepciones poniendolo como String.

            switch (respuesta) {
                case "1":
                    System.out.println("Bien! Jugaras el nivel facil.");
                    System.out.println("Podras hacer hasta un maximo de 20 preguntas. Suerte!");
                    break;
                case "2":
                    System.out.println("Bien! Jugaras el nivel medio.");
                    System.out.println("Podras hacer hasta un maximo de 10 preguntas. Suerte!");
                    break;
                case "3":
                    System.out.println("Bien! Jugaras el nivel dificil.");
                    System.out.println("Podras hacer hasta un maximo de 5 preguntas. Suerte!");
                    break;
                default:
                    System.out.println("Error! No has introducido una opcion correcta.");
                    break;
            }
        } while (!respuesta.matches("[1-3]")); // Si no es 1, 2 o 3, repite el menu

        return Integer.parseInt(respuesta); // Aqui la respuesta es 1, 2 o 3
    }

    // Metodo en el cual generamos un numero al azar entre el 1 y el 100
    public static int pensarNumero() {
        Random r = new Random();
        return (int) (r.nextDouble() * 100 + 1); // (int) (r.nextDouble() * numTotalNumeros + primerNumeroCadenaNumeros)
    }

    // Metodo con el cual devolvemos el num max de preguntas permitidas segun la dificultad.
    public static int aplicarNumMaxPreguntas(int dificultad) {
        int numeroMaxPreguntas = 0;

        switch (dificultad) { // Aplicamos el numero max de preguntas segun dicho nivel
            case 1:
                numeroMaxPreguntas = 20;
                break;
            case 2:
                numeroMaxPreguntas = 10;
                break;
            case 3:
                numeroMaxPreguntas = 5;
                break;
        }
        return numeroMaxPreguntas;
    }

    public static void jugar() {
        int nivelDificultad;
        int preguntasRealizadas = 0, numeroMaxPreguntas = 0;
        int numeroResolver;
        Scanner teclado = new Scanner(System.in);

        nivelDificultad = menu(); // Elegimos el nivel de dificultad
        numeroMaxPreguntas = aplicarNumMaxPreguntas(nivelDificultad); // Asignamos el numero max de preguntas segun la dificultad.
        numeroResolver = pensarNumero(); // Numero que se tiene que resolver por el humano.
        System.out.println(numeroResolver);
        System.out.println("Pulsa Enter para comenzar el juego...");
        teclado.nextLine();

        while (preguntasRealizadas < numeroMaxPreguntas) {
            String numero = "";
            System.out.println("Pregunta " + (1 + preguntasRealizadas));
            System.out.println("Inserta un numero -> ");
            numero = teclado.nextLine();

            if (numero.matches("[0-9]*")) {
                if (Integer.parseInt(numero) > numeroResolver) {
                    System.out.println("El numero que he pensado es MENOR que " + numero);
                } else if (Integer.parseInt(numero) < numeroResolver) {
                    System.out.println("El numero que he pensado es MAYOR que " + numero);
                } else {
                    System.out.println("ENHORABUENA! Has adivinado el numero!");
                    System.out.println("Lo has logrado en " + (1 + preguntasRealizadas) + " intentos de " + numeroMaxPreguntas);
                    preguntasRealizadas = numeroMaxPreguntas;
                }
                preguntasRealizadas++;
            } else {
                System.out.println("No has introducido un numero. Intentalo de nuevo.");
            }
        }
        System.out.println("Fin del juego.");
    }

    public static void main(String[] args) {
        jugar();
    }
}
