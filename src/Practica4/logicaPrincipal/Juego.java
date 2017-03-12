package Practica4.logicaPrincipal;

import Practica4.factories.PersonajesFactory;
import Practica4.personajes.Personaje;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private Personaje jugador;
    private ArrayList<Personaje> enemigos;
    PersonajesFactory factoriaPersonajes;
    private int numeroEnemigos;

    public Juego(int numeroEnemigos) {
        this.numeroEnemigos = numeroEnemigos;
        this.enemigos = new ArrayList<>();
        this.factoriaPersonajes = new PersonajesFactory();
    }

    //Se elige el tipo de jugador con el que se quiere jugar
    private int pedirTipoJugador() {
        Scanner scanner = new Scanner(System.in);
        String seleccion = "";
        do {
            System.out.println("Elige un tipo de personaje con el que jugar.");
            System.out.println("\n1. Cazador \n2. Guerrero \n3. Mago");
            seleccion = scanner.nextLine();
        } while (!seleccion.matches("[123]"));

        return Integer.parseInt(seleccion);
    }

    //Se crea al jugador propio
    private void crearJugador() {
        //Creo al jugador.
        System.out.println("Vas a crear a tu personaje.\n");
        jugador = factoriaPersonajes.crearPersonaje(pedirTipoJugador());
    }

    //Se crea a los enemigos 
    private void crearEnemigos() {
        //Creo a los enemigos
        System.out.println("\nVas a crear a los " + numeroEnemigos + " enemigos.");
        for (int i = 0; i < numeroEnemigos; i++) {
            System.out.println("\nEnemigo " + (i + 1) + "\n");
            enemigos.add(factoriaPersonajes.crearPersonaje((i + 1)));
        }
    }

    //Pedir al jugador si quiere abandonar o no la partida
    private static int salirJuego() throws IOException {
        System.out.println("Fin de la partida. \n\nPulsa 'E' para salir o "
                + "pulsa 'otra tecla' para seguir jugando...");
        return System.in.read();
    }

    //Inicializa jugador y enemigos
    public void nuevaPartida() {
        crearJugador();
        crearEnemigos();
    }

    //Combate entre jugador y enemigos
    public void iniciarJuego() throws IOException {
        for (int i = 0; i < enemigos.size(); i++) {
            jugador.combatir(enemigos.get(i));

            if (jugador.estaDerrotado()) {
                break;
            }

            if ((i + 1) < enemigos.size()) {
                System.out.println("SIGUE LA PELEA CON EL SIGUIENTE ENEMIGO");
            }
        }
    }

    //Reinicia la partida
    public void reiniciar() {
        jugador = new Personaje();
        enemigos.clear();
    }

    public static void main(String[] args) throws IOException {
        Juego juego = new Juego(1); //3 enemigos

        //Bucle principal del juego
        do {
            juego.nuevaPartida();
            juego.iniciarJuego();
            juego.reiniciar();
        } while (salirJuego() != 101 && salirJuego() != 69); //'e' = 101 , 'E' = 69

        System.out.println("Espero que vuelvas a jugar pronto!");
    }
}
