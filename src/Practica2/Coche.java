package Practica2;

/**
 * Clase para el ejercicio 1
 */
public class Coche {

    private String marca;
    private String modelo;
    private String color;
    private int numMarchas;
    private boolean cocheArrancado;
    private int marchaActual;
    private float velocidad;

    public Coche(String marca, String modelo, String color, int numMarchas) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.numMarchas = numMarchas;
        this.cocheArrancado = false;
        this.marchaActual = 0; //PuntoMuerto
        this.velocidad = 0.0f;
    }

    public String arrancarCoche() {
        if (cocheArrancado) {
            return "No puedes arrancar el coche. Ya lo habias hecho anteriormente.";
        }
        cocheArrancado = true;
        return "Has arrancado correctamente el coche.";
    }

    public String pararCoche() {
        if (!cocheArrancado) {
            return "No puedes parar el coche. No lo habias arrancado todavia.";
        }
        cocheArrancado = false;
        return "Has parado correctamente el coche.";
    }

    public String describirCoche() {
        return "Coche{" + "Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Numero de marchas: " + numMarchas + '}';
    }

    public String subirMarcha() {
        if (!cocheArrancado) {
            return "No subes de marcha porque no has arrancado el coche.";
        }
        if (marchaActual == numMarchas) {
            return "No se puede subir más de marcha";
        }
        marchaActual++;
        return "Pasas de la marcha " + (marchaActual - 1) + " a la marcha " + marchaActual;
    }

    public String bajarMarcha() {
        if (!cocheArrancado) {
            return "No bajas de marcha porque no has arrancado el coche.";
        }
        if (marchaActual == 0) {
            return "No se puede bajar más de marcha. Tienes punto muerto puesto.";
        }
        marchaActual--;
        return "Pasas de la marcha " + (marchaActual + 1) + " a la marcha " + marchaActual;
    }

    public String acelerar() {
        if (!cocheArrancado) {
            return "No aceleras porque no has arrancado el coche.";
        }
        velocidad += (9.8 * 1.232);
        return "Tu velocidad actual es de " + velocidad + "km/h";
    }

    public String frenar() {
        if (!cocheArrancado) {
            return "No frenas porque no has arrancado el coche.";
        }
        velocidad -= (9.8 * 1.532);
        if (velocidad <= 0) {
            velocidad = 0;
        }
        return "Tu velocidad actual es de " + velocidad;
    }
}
