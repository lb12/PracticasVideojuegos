package Practica2;

import java.text.DecimalFormat;

/**
 * Clase para el ejercicio 5
 */
public class CalculadoraVersionNueva implements CalculadoraInterface {

    DecimalFormat df = new DecimalFormat("###,###.##");

    @Override
    public String suma(double a, double b) {
        return df.format(a + b);
    }

    @Override
    public String resta(double a, double b) {
        return df.format(a - b);
    }

    @Override
    public String multiplicacion(double a, double b) {
        return df.format(a * b);
    }

    @Override
    public String division(double a, double b) {
        if (b == 0) { //Division por 0
            return String.valueOf(Double.NaN);
        }
        return df.format(a / b);
    }

}
