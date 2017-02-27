package Practica2;

import java.text.DecimalFormat;

/**
 * Clase para el ejercicio 3
 */
public class Calculadora {

    DecimalFormat df = new DecimalFormat("###,###.##");

    public String suma(double a, double b) {
        return df.format(a + b);
    }

    public String resta(double a, double b) {
        return df.format(a - b);
    }

    public String multiplicacion(double a, double b) {
        return df.format(a * b);
    }

    public String division(double a, double b) {
        if (b == 0) { //Division por 0
            return String.valueOf(Double.NaN);
        }
        return df.format(a / b);
    }
}
