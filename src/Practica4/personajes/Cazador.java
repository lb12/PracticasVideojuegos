package Practica4.personajes;

import Practica4.armas.Arco;

public class Cazador extends Personaje {

    protected int energia;
    protected int mana;

    public Cazador(int pv, int destreza, int energia, int mana) {
        super(pv, destreza);
        this.energia = energia;
        this.mana = mana;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Cazador\n{ " + super.toString() + "\n\tCantidad de energia: " + energia + " puntos\n\tCantidad de mana: " + mana + "\n}";
    }
}
