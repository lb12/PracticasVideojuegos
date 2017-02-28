package Practica3.personajes;

import Practica3.armas.Espada;

public class Guerrero extends Personaje {

    protected int ira;

    public Guerrero(String nombre, int pv, int destreza, Espada espada, int ira) {
        super(nombre, pv, destreza, espada);
        this.ira = ira;
    }

    public int getIra() {
        return ira;
    }

    public void setIra(int ira) {
        this.ira = ira;
    }

    @Override
    public String toString() {
        return "Guerrero\n{ " + super.toString() + "\n\tCantidad de ira: " + ira + " puntos\n}";
    }
}
