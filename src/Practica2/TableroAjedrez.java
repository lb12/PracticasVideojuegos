package Practica2;

import java.util.ArrayList;

/**
 * Clase para el ejercicio 4
 */
public class TableroAjedrez {

    private char[][] tablero;

    //Metodo para crear un tablero desde 0 o actualizar uno
    private void crearTablero(ArrayList<int[]> al) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (al == null) { //Creo el tablero desde 0
                    if (esPar(i, j)) {
                        tablero[i][j] = 'B';
                        continue;
                    }
                    tablero[i][j] = 'N';
                    continue;
                }
                //Obtengo un tablero actualizado
                for (int k = 0; k < al.size(); k++) {
                    int[] p = new int[2];
                    p[0] = al.get(k)[0];
                    p[1] = al.get(k)[1];
                    if (p[0] == i && p[1] == j) {
                        tablero[i][j] = '*';
                    }
                }
            }
        }
    }

    //Metodo para comprobar si dos numeros son pares
    private boolean esPar(int i, int j) {
        return ((i + j) % 2) == 0;
    }

    //Metodo que calcula la posicion de la matriz segun nos la da el usuario
    private int[] parsearPosicion(int i, char j) {
        int[] posicion = new int[2];
        char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        posicion[0] = (8 - i);
        for (int k = 0; k < 8; k++) {
            if (letras[k] == j) {
                posicion[1] = k;
                break;
            }
        }
        return posicion; //Posicion en la que se encuentra el jugador. Ej: 3,f => [5][5]
    }

    //Obtiene las posiciones de la diag izq superior que entran en la matriz
    private ArrayList<int[]> diagIzqArriba(int i, int j, ArrayList<int[]> al) {
        if (i == 0 || j == 0) {
            return al;
        }
        int[] a = new int[2];
        a[0] = (i - 1);
        a[1] = (j - 1);
        al.add(a);
        return diagIzqArriba((i - 1), (j - 1), al);
    }

    //Obtiene las posiciones de la diag der superior que entran en la matriz
    private ArrayList<int[]> diagDerArriba(int i, int j, ArrayList<int[]> al) {
        if (i == 0 || j == 7) {
            return al;
        }
        int[] a = new int[2];
        a[0] = (i - 1);
        a[1] = (j + 1);
        al.add(a);
        return diagDerArriba((i - 1), (j + 1), al);
    }

    //Obtiene las posiciones de la diag der inferior que entran en la matriz
    private ArrayList<int[]> diagDerAbajo(int i, int j, ArrayList<int[]> al) {
        if (i == 7 || j == 7) {
            return al;
        }
        int[] a = new int[2];
        a[0] = (i + 1);
        a[1] = (j + 1);
        al.add(a);
        return diagDerAbajo((i + 1), (j + 1), al);
    }

    //Obtiene las posiciones de la diag izq inferior que entran en la matriz
    private ArrayList<int[]> diagIzqAbajo(int i, int j, ArrayList<int[]> al) {
        if (i == 7 || j == 0) {
            return al;
        }
        int[] a = new int[2];
        a[0] = (i + 1);
        a[1] = (j - 1);
        al.add(a);
        return diagIzqAbajo((i + 1), (j - 1), al);
    }

    //Reune las posiciones de diagonales, recrea el tablero y lo imprime.
    private void obtenerTableroPosiciones(int[] pos) {
        ArrayList<int[]> movimientosAlfil = new ArrayList<>();
        movimientosAlfil.add(pos);
        movimientosAlfil = diagIzqArriba(pos[0], pos[1], movimientosAlfil);
        movimientosAlfil = diagDerArriba(pos[0], pos[1], movimientosAlfil);
        movimientosAlfil = diagDerAbajo(pos[0], pos[1], movimientosAlfil);
        movimientosAlfil = diagIzqAbajo(pos[0], pos[1], movimientosAlfil);

        crearTablero(movimientosAlfil);
        imprimirTablero();
    }

    //Constructor
    public TableroAjedrez() {
        tablero = new char[8][8];
        crearTablero(null);
    }

    //Imprimer un tablero con las posiciones a las que puede mover un alfil
    public void imprimirTableroPosiciones(int i, char j) {
        obtenerTableroPosiciones(parsearPosicion(i, j));
    }

    //Imprime el tablero actual
    public void imprimirTablero() {
        char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        //Imprimo letras que representan la columna
        System.out.print("\n    ");
        for (int i = 0; i < 8; i++) {
            System.out.print(letras[i] + " ");
        }
        //Imprimo separador "_"
        System.out.print("\n" + "   ");
        for (int i = 0; i < 16; i++) {
            System.out.print("_");
        }
        //Imprimo numeros que representan la fila
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " |" + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(tablero[i][j] + " "); //Contenido de la celda
                if (j == 7) {
                    System.out.println("");
                }
            }
        }
    }

    //Obtener el tablero.
    public char[][] getTablero() {
        return tablero;
    }

}
