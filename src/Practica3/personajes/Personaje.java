package Practica3.personajes;

import Practica3.armas.Arma;

public class Personaje {

    protected String nombre;
    protected int pv;
    protected int destreza;
    protected Arma arma;

    public Personaje(String nombre, int pv, int destreza, Arma arma) {
        this.nombre = nombre;
        this.pv = pv;
        this.destreza = destreza;
        this.arma = arma;
    }

    public boolean estaDerrotado() {
        return pv <= 0;
    }

    private void atacar(Personaje enemigo) {
        //Recibo daño del enemigo        
        if (enemigo.getArma().estaDisponible()) {
            pv -= enemigo.getArma().getDanyo();
            enemigo.getArma().usar(); //El enemigo usa el arma  

            //Solo puedes quitar danyo con destreza si el arma no esta rota o tienes arma
            if (enemigo.getDestreza() > 0) {
                pv -= enemigo.destreza;
            }
        }

        //Hago daño al enemigo
        if (arma.estaDisponible()) {
            enemigo.setPv(enemigo.getPv() - arma.getDanyo());
            arma.usar(); //Uso el arma

            //Solo puedes quitar danyo con destreza si el arma no esta rota o tienes arma
            if (destreza > 0) {
                enemigo.setPv(enemigo.getPv() - destreza);
            }
        }
        //Evitar puntos en negativo
        if (pv < 0) {
            pv = 0;
        }
        if (enemigo.getPv() < 0) {
            enemigo.setPv(0);
        }
    }

    public void combatir(Personaje enemigo) {
        while (!estaDerrotado() && !enemigo.estaDerrotado()) {
            //peleais
            atacar(enemigo);
        }

        if (estaDerrotado()) {
            System.out.println(enemigo.getNombre() + " ha ganado a " + nombre);
        }

        System.out.println(nombre + " ha ganado a " + enemigo.getNombre());
        System.out.println("Resultados de la pelea...");
        System.out.println(enemigo.toString());
        System.out.println(toString());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "\n\tNombre del personaje: " + nombre + "\n\tVida: " + pv + " puntos\n\tDestreza: " + destreza + " puntos\n\tArma: "
                + arma.toString();
    }
}
