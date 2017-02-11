package Practica1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio10 {

    /*
     * Modifique el ejercicio anterior cambiando los roles: 
     * El humano elige un número y el ordenador realiza las preguntas.
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
                    System.out.println("La maquina podrá hacer hasta un maximo de 20 preguntas. Suerte!");
                    break;
                case "2":
                    System.out.println("Bien! Jugaras el nivel medio.");
                    System.out.println("La maquina podrá hacer hasta un maximo de 10 preguntas. Suerte!");
                    break;
                case "3":
                    System.out.println("Bien! Jugaras el nivel dificil.");
                    System.out.println("La maquina podrá hacer hasta un maximo de 5 preguntas. Suerte!");
                    break;
                default:
                    System.out.println("Error! No has introducido una opcion correcta.");
                    break;
            }
        } while (!respuesta.matches("[1-3]")); // Si no es 1, 2 o 3, repite el menu

        return Integer.parseInt(respuesta); // Aqui la respuesta es 1, 2 o 3
    }

    // Metodo en el cual generamos un numero al azar entre el 1 y el 100
    public static int pensarNumero(int minimo, int maximo) {
        Random r = new Random();
        return (int) (r.nextDouble() * ((maximo + 1) - minimo) + minimo); // (int) (r.nextDouble() * numTotalNumeros + primerNumeroCadenaNumeros)
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
        int numeroPensado;
        boolean maquinaGana = false;
        String opcionSeleccionada;
        Scanner teclado = new Scanner(System.in);

        nivelDificultad = menu(); // Elegimos el nivel de dificultad
        numeroMaxPreguntas = aplicarNumMaxPreguntas(nivelDificultad); // Asignamos el numero max de preguntas segun la dificultad.
        numeroPensado = pensarNumero(1, 100); //Numero pensado segun la maquina del 1 al 100.

        System.out.println("Piensa un numero para que la maquina lo adivine.");
        System.out.println("Cuando estes preparado, pulsa ENTER para comenzar el juego...");
        teclado.nextLine();

        while ((!maquinaGana) && preguntasRealizadas < numeroMaxPreguntas) {
            System.out.println("Pregunta " + (1 + preguntasRealizadas));
            System.out.println("El numero que he pensado es: " + numeroPensado);
            System.out.println("Es este numero correcto?");

            do {
                System.out.println("\n\nSelecciona una opcion:");
                System.out.println("1. Si! Enhorabuena.");
                System.out.println("2. No, tu numero (" + numeroPensado + ") es mayor que el pensado.");
                System.out.println("3. No, tu numero (" + numeroPensado + ") es menor que el pensado.");
                opcionSeleccionada = teclado.nextLine();
            } while (!opcionSeleccionada.matches("[1-3]"));

            switch (opcionSeleccionada) {
                case "1":
                    System.out.println("¡LA MAQUINA HA ACERTADO TU NUMERO!");
                    System.out.println("Lo ha logrado en " + (1 + preguntasRealizadas) + " intentos de " + numeroMaxPreguntas);
                    maquinaGana = true; //Escape del bucle (hemos terminado el juego)
                    break;
                case "2":
                    numeroPensado = pensarNumero(1, numeroPensado); //La maquina piensa un numero desde el 1 hasta el numero que ha dicho porque es menor.                    
                    break;
                case "3":
                    numeroPensado = pensarNumero(numeroPensado, 100); //La maquina piensa un numero desde el que ha dicho hasta 100 porque es mayor.
                    break;
            }
            preguntasRealizadas++;
        }

        System.out.println("FIN DEL JUEGO.\n");
        if (!maquinaGana) {
            System.out.println("¡ENHORABUENA! Has conseguido que la maquina no acierte tu numero. ");
        }
    }

    public static void main(String[] args) {
        jugar();
    }
}
