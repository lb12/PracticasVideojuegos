package Practica4.armas;

public class Baston extends Arma {

    protected int puntosMagia;

    public Baston(String nombre, int danyo, int puntosMagia) {
        super(nombre, danyo);
        this.puntosMagia = puntosMagia;
        //this.puntosMagia = 15;
    }

    @Override
    public void usar() {
        puntosMagia -= 2;
        if (puntosMagia < 0) {
            puntosMagia = 0;
        }
    }

    @Override
    public boolean estaDisponible() {
        return puntosMagia > 0;
    }

    public int getPuntosMagia() {
        return puntosMagia;
    }

    public void setPuntosMagia(int puntosMagia) {
        this.puntosMagia = puntosMagia;
    }

    @Override
    public String toString() {
        return "Baston\n\t{" + super.toString() + "\n\t\tPuntos de Magia: " + puntosMagia + " puntos\n\t}";
    }
}
