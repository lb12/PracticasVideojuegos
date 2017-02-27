package Practica2;

/**
 * Diseñe e implemente una clase Calculadora que calcule la suma, resta,
 * división y multiplicación de dos números que se pasarán como argumento a los
 * métodos. ¿Es necesario utilizar atributos? Discútalo con el profesor del
 * laboratorio
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        System.out.println("4 + 5 = " + c.suma(4, 5));
        System.out.println("4.3265 - 10.2457 = " + c.resta(4.3265, 10.2457));
        System.out.println("36541.325 / 123.00002211 = " + c.division(36541.325, 123.00002211));
        System.out.println("12 / 0 = " + c.division(12, 0));
        System.out.println("23.6521 * pi = " + c.multiplicacion(23.6521, Math.PI));
    }
}

/**
 * No nos es necesario crear atributos ya que simplemente con pasar los valores
 * a los metodos ya retornan lo que necesitamos por lo que no es necesario que
 * utilicemos memoria para almacenar variables que no vamos a necesitar.
 */
