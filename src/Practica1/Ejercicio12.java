package Practica1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio12 {

    /*
     * Implemente el juego del ahorcado en modo texto
     */
    private static ArrayList<String> crearDiccionario(ArrayList conjuntoPalabras) {
        conjuntoPalabras.add("Basurero");
        conjuntoPalabras.add("Armario");
        conjuntoPalabras.add("Superfluo");
        conjuntoPalabras.add("Ventrilocuo");
        conjuntoPalabras.add("Arbol");
        return conjuntoPalabras;
    }

    private static char[] inicializarPalabra(char[] palabra, int tamanyo) {
        for (int i = 0; i < tamanyo; i++) {
            palabra[i] = '?';
        }

        return palabra;
    }

    private static void mostrarPalabraOculta(char[] palabraFormada) {
        System.out.println("\n\n");
        for (int i = 0; i < palabraFormada.length; i++) {
            System.out.printf("__" + palabraFormada[i] + "__");
        }
        System.out.println("\n\n");
    }

    private static void imprimirPaloyBase(int numLargo) {
        for (int j = 0; j < numLargo; j++) {
            System.out.println(" |");
        }
        System.out.println("__________");
    }

    private static void dibujar(int i) {
        switch (i) {
            case 0: //0 vidas (muerto)
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | X  X  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                System.out.println(" |                    / \\");
                System.out.println(" |                   /   \\  ");
                System.out.println(" |                  /     \\ ");
                imprimirPaloyBase(2);
                System.out.println("GAME OVER");
                break;
            case 1: //1 vida
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                System.out.println(" |                    /  ");
                System.out.println(" |                   /      ");
                System.out.println(" |                  /       ");
                imprimirPaloyBase(2);
                break;
            case 2: //2 vidas
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / | \\ ");
                System.out.println(" |                  /  |   \\ ");
                System.out.println(" |                 /   |     \\ ");
                System.out.println(" |                     |   ");
                imprimirPaloyBase(5);
                break;
            case 3: //3 vidas
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / |   ");
                System.out.println(" |                 /   |   ");
                System.out.println(" |                /    |   ");
                System.out.println(" |                     |   ");
                imprimirPaloyBase(5);
                break;
            case 4: //4 vidas
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                imprimirPaloyBase(5);
                break;
            case 5: //5 vidas
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                imprimirPaloyBase(10);
                break;
            case 6: //6 vidas (comienzo del juego
                System.out.println(" ---------------------");
                imprimirPaloyBase(15);
                break;
        }
    }

    public static void jugarAhorcado() {
        Scanner teclado = new Scanner(System.in);
        int numVidas;
        int numAciertos;
        ArrayList<String> conjuntoPalabras; //Conjunto de palabras posibles a adivinar
        String palabraPensada; //Palabra seleccionada para adivinar
        char[] palabraFormada; //Palabra que se completa segun se adivinan las letras que contiene
        String letraIntroducida; //Letra que introduce el jugador.

        //Inicializar variables
        numVidas = 6;
        numAciertos = 0;
        conjuntoPalabras = new ArrayList<>();
        conjuntoPalabras = crearDiccionario(conjuntoPalabras);
        palabraPensada = conjuntoPalabras.get((int) (Math.random() * conjuntoPalabras.size()));
        palabraFormada = new char[palabraPensada.length()];
        palabraFormada = inicializarPalabra(palabraFormada, palabraPensada.length());

        //Bucle del juego
        while (numAciertos < palabraFormada.length && numVidas > 0) {
            System.out.println("VIDAS = " + numVidas);
            dibujar(numVidas);
            mostrarPalabraOculta(palabraFormada); //Mostramos al jugador la palabra oculta

            System.out.println("Introduce una letra");
            letraIntroducida = teclado.next();

            if (palabraPensada.toLowerCase().contains(letraIntroducida.toLowerCase())) {
                for (int i = 0; i < palabraFormada.length; i++) {
                    if (palabraPensada.toLowerCase().charAt(i) == letraIntroducida.toLowerCase().charAt(0)) {
                        palabraFormada[i] = letraIntroducida.toUpperCase().charAt(0);
                        numAciertos++;
                    }
                }
            } else {
                numVidas--;
            }
        }

        if (numVidas > 0) { //Ha salido porque ha acertado la palabra
            System.out.println("\n");
            System.out.println("¡ENHORABUENA! ¡Has adivinado la palabra correctamente!");
            mostrarPalabraOculta(palabraFormada);
        } else { //Ha salido porque se ha quedado sin vidas
            dibujar(0);
        }
    }

    public static void main(String[] args) {
        jugarAhorcado();
    }
}
