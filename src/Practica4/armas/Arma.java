package Practica4.armas;

public abstract class Arma {

    protected String nombre;
    protected int danyo;

    public Arma(String nombre, int danyo) {
        this.nombre = nombre;
        this.danyo = danyo;
    }
    
    //Metodo que simula la utilizacion del arma
    public abstract void usar();
    
    //Metodo que indica si el arma esta lista para combatir
    public abstract boolean estaDisponible();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanyo() {
        return danyo;
    }

    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }
    
    @Override
    public String toString() {
        return "\n\t\tNombre del arma: " + nombre + "\n\t\tDaño: " + danyo + " puntos"; 
    }    
    

}
