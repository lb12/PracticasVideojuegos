package Practica3.armas;

public class Arco extends Arma {

    protected int numFlechas;

    public Arco(String nombre, int danyo, int numFlechas) {
        super(nombre, danyo);
        //this.numFlechas = numFlechas;
        this.numFlechas = 10;
    }

    @Override
    public void usar() {
        numFlechas--;
        if (numFlechas < 0) {
            numFlechas = 0;
        }
    }

    @Override
    public boolean estaDisponible() {
        return numFlechas > 0;
    }

    public int getNumFlechas() {
        return numFlechas;
    }

    public void setNumFlechas(int numFlechas) {
        this.numFlechas = numFlechas;
    }

    @Override
    public String toString() {
        return "Arco\n\t{" + super.toString() + "\n\t\tCapacidad carcaj: " + numFlechas + " flechas\n\t}";
    }

}
