package Practica4.personajes;

import Practica4.armas.Espada;

public class Guerrero extends Personaje {

    protected int ira;

    public Guerrero(int pv, int destreza,int ira) {
        super(pv, destreza);
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
