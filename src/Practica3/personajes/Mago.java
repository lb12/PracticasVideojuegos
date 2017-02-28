package Practica3.personajes;

import Practica3.armas.Baston;

public class Mago extends Personaje {

    protected int mana;

    public Mago(String nombre, int pv, int destreza, Baston baston, int mana) {
        super(nombre, pv, destreza, baston);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    @Override
    public String toString() {
        return "Mago\n{ " + super.toString() + "\n\tCantidad de mana: " + mana + " puntos\n}";
    }
}
