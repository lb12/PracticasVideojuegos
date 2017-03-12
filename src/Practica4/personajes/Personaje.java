package Practica4.personajes;

import Practica4.armas.Arco;
import Practica4.armas.Arma;
import Practica4.armas.Espada;
import Practica4.inventario.Inventario;
import java.io.IOException;
import java.util.Scanner;

public class Personaje {

    protected String nombre;
    protected int pv;
    protected int destreza;
    protected Arma arma;

    private Inventario inventario; //Delegation

    public Personaje(int pv, int destreza) {
        this.nombre = pedirNombrePersonaje();
        this.pv = pv;
        this.destreza = destreza;
        this.arma = null;
        this.inventario = new Inventario();
    }

    public Personaje() {

    }

    //Metodos para el personaje
    private String pedirNombrePersonaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Escribe el nombre del personaje: ");
        return scanner.nextLine();
    }

    public boolean estaDerrotado() {
        return pv <= 0;
    }

    private void atacaEnemigo(Personaje enemigo) {
        if (enemigo.getArma().estaDisponible()) {
            pv -= enemigo.getArma().getDanyo();

            //Solo puedes quitar danyo con destreza si el arma no esta rota o tienes arma
            if (enemigo.getDestreza() > 0) {
                pv -= enemigo.destreza;
            }

            enemigo.getArma().usar(); //El enemigo usa el arma  
        }
    }

    private void atacaMiPersonaje(Personaje enemigo) {
        if (arma.estaDisponible()) {
            enemigo.setPv(enemigo.getPv() - arma.getDanyo());

            //Solo puedes quitar danyo con destreza si el arma no esta rota o tienes arma
            if (destreza > 0) {
                enemigo.setPv(enemigo.getPv() - destreza);
            }

            arma.usar(); //Uso el arma
        }
    }

    private void atacar(Personaje enemigo) {

        if (enemigo.getDestreza() > this.getDestreza()) {
            atacaEnemigo(enemigo);//El enemigo ataca antes que yo
            if (!estaDerrotado()) { //Si tras el golpe, sigo vivo
                atacaMiPersonaje(enemigo); //Entonces ataco
            }
        } else { //Yo tengo mas destreza que el
            atacaMiPersonaje(enemigo); //Le ataco primero
            if (!enemigo.estaDerrotado()) { //Si tras el golpe, sigue vivo
                atacaEnemigo(enemigo); //Entonces me ataca
            }
        }

        //Evitar puntos en negativo
        if (estaDerrotado()) {
            pv = 0;
        }
        if (enemigo.estaDerrotado()) {
            enemigo.setPv(0);
        }
    }

    public void combatir(Personaje enemigo) throws IOException {
        while (!estaDerrotado() && !enemigo.estaDerrotado()) {
            //Si los dos estan vivos, pelean
            atacar(enemigo);
            System.out.println("Resultados del ataque...");
            System.out.println(toString()); //Mis datos tras el ataque
            System.out.println(enemigo.toString()); //Datos del enemigo tras el atq
            System.in.read();
        }

        System.out.println("Resultados de la pelea...");

        if (estaDerrotado()) {
            System.out.println(enemigo.getNombre() + " ha ganado a " + nombre);
        } else {
            System.out.println(nombre + " ha ganado a " + enemigo.getNombre());
        }
        System.out.println(toString()); //Mis datos finales
        System.out.println(enemigo.toString()); //Datos finales del enemigo        
    }

    //Metodos para el Inventario
    public void seleccionarArma(String nombreArma) {
        arma = inventario.seleccionarArma(nombreArma, arma);
    }

    public void soltarArma(Arma arma) {
        inventario.soltarArma(arma);
    }

    public void tomarArma(Arma arma) {
        inventario.tomarArma(arma);
    }

    public void imprimirInventario() {
        inventario.imprimirInventario();
    }

    //Getter y Setter
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

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public String toString() {
        return "\n\tNombre del personaje: " + nombre + "\n\tVida: " + pv + " puntos\n\tDestreza: " + destreza + " puntos\n\tArma: "
                + arma.toString();
    }
}
