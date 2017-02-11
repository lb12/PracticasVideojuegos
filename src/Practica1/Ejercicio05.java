package Practica1;

public class Ejercicio05 {

    /*
     * Escribir un programa que muestre el n�mero de caracteres ocupados por una
     * cadena. Modifique el programa para que muestre el n�mero de veces que
     * aparece una vocal.
     */
    public static int obtenerNumVocales(String cadena) {
        int contador = 0;
        char[] cad = cadena.toLowerCase().toCharArray();
        for (int i = 0; i < cadena.length(); i++) {
            if (cad[i] == 'a' || cad[i] == 'e' || cad[i] == 'i' || cad[i] == 'o'
                    || cad[i] == 'u') {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        String cadena = "Esta es mi cadena a calcular.";
        System.out.println("La cadena a analizar es: \"" + cadena + "\"");
        System.out.println("Longitud de la cadena --> " + cadena.length());
        System.out.println("Numero de vocales en la cadena: " + obtenerNumVocales(cadena));
    }
}
