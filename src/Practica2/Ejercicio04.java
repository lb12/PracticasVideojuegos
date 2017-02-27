package Practica2;

/**
 * Implemente una clase TableroAjedrez que visualice en modo texto un tablero de
 * ajedrez (8x8), usando ’N’ para identificar casillas negras, y ’B’ las
 * casillas blancas. Implementar un método adicional que imprima el tablero,
 * pero indicando además a qué casillas se puede mover un alfil dada una
 * determinada posición en forma (fila, columna). Utilice los siguientes
 * métodos:
 *
 * 1. pubic void imprimirTablero(): Imprime un tablero sin fichas. 2. public
 * void imprimirTablero(int fila, int columna): Imprime el tablero y las
 * posiciones a las que se puede mover un alfil en la ubicación dada.
 *
 * Optativo: Diseñe (e implemente) una nueva clase que permita visualizar el
 * tablero y los movimientos válidos de varias figuras (por ejemplo, torre,
 * caballo y alfil) atendiendo a los principios de modularidad, encapsulamiento
 * y reutilización. Discuta el diseño con el profesor del laboratorio.
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        TableroAjedrez ta = new TableroAjedrez(); //Crea el tablero 
        ta.imprimirTablero(); //Imprime el tablero      

        /**
         * Imprimo las posiciones a las que se puede mover un alfil en la
         * posicion (3,e) del tablero
         */
        ta.imprimirTableroPosiciones(3, 'e');
    }

}
