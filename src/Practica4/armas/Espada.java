package Practica4.armas;

public class Espada extends Arma {

    protected int resistencia;

    public Espada(String nombre, int danyo, int resistencia) {
        super(nombre, danyo);
        this.resistencia = resistencia;
        //this.resistencia = 20;
    }

    @Override
    public void usar() {
        resistencia -= 3;
        if (resistencia < 0) {
            resistencia = 0;
        }
    }

    @Override
    public boolean estaDisponible() {
        return resistencia > 0;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Espada\n\t{" + super.toString() + "\n\t\tResistencia: " + resistencia + " puntos\n\t}";
    }

}
