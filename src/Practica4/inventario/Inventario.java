package Practica4.inventario;

import Practica4.armas.Arma;
import java.util.LinkedList;
import java.util.List;

public class Inventario {

    private List<Arma> inventario = new LinkedList<>();

    //Metodo que devuelve el contenido de tu inventario
    public void imprimirInventario() {
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i).toString());
        }
    }

    //Metodo que añade un arma a tu inventario
    public void tomarArma(Arma arma) {
        inventario.add(arma);
    }

    //Metodo que obtiene un arma que tengas en el inventario
    public Arma seleccionarArma(String nombreArma, Arma arma) {
        for (int i = 0; i < inventario.size(); i++) {
            //Si encontramos ese arma en el inventario, la equipamos, sino, devolvemos la misma que teniamos en la mano.
            if (inventario.get(i).getNombre().equals(nombreArma)) {
                arma = inventario.get(i);
            }
        }
        return arma;
    }

    //Metodo que elimina un arma del inventario
    public void soltarArma(Arma arma) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).equals(arma)) {
                inventario.remove(inventario.get(i));
            }
        }
    }

    public List<Arma> getInventario() {
        return inventario;
    }
}
