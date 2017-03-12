package Practica4.personajes;

import Practica4.armas.Baston;

public class Mago extends Personaje {

    protected int mana;

    public Mago(int pv, int destreza, int mana) {
        super(pv, destreza);
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
