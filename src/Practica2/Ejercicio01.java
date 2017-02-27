package Practica2;

/**
 * Implemente la clase Coche que represente coches. Incluya los atributos marca,
 * modelo, marcha y color; y los métodos que simulen las acciones de arrancar el
 * motor, describir el coche, cambiar de velocidad (subir y bajar marcha),
 * acelerar, frenar y parar el motor (simplemente muestre un texto por pantalla
 * o modificando algún atributo). Muestre el funcionamiento de la clase creando
 * tres instancias de la clase representando coches diferentes, llamando a sus
 * métodos y visualizando el resultado por pantalla.
 */
public class Ejercicio01 {
        
    public static void main(String[] args){
        Coche c1 = new Coche("Ford", "Mondeo", "Dorado", 6);
        Coche c2 = new Coche("Seat", "Ibiza", "Rojo", 5);
        Coche c3 = new Coche("Ford", "Fiesta", "Plata", 5);
        
        //Pruebas con el coche 1
        System.out.println(c1.describirCoche());
        System.out.println(c1.arrancarCoche());
        System.out.println(c1.bajarMarcha());
        System.out.println(c1.subirMarcha());
        System.out.println(c1.acelerar());
        System.out.println(c1.acelerar());
        System.out.println(c1.subirMarcha());
        System.out.println(c1.frenar());
        System.out.println(c1.frenar());
        System.out.println(c1.bajarMarcha());
        System.out.println(c1.bajarMarcha());
        System.out.println(c1.pararCoche());
        
        
    }

}
