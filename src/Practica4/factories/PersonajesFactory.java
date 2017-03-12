package Practica4.factories;

import Practica4.armas.*;
import Practica4.personajes.Cazador;
import Practica4.personajes.Guerrero;
import Practica4.personajes.Mago;
import Practica4.personajes.Personaje;
import java.util.Scanner;

public class PersonajesFactory {

    private static Scanner scanner = new Scanner(System.in);
    private static ArmasFactory factoriaArmas = new ArmasFactory();

    public Personaje crearPersonaje(int personaje) {
        Personaje p = null;

        String puntosVida, destreza;

        //Pido los atributos basicos del personaje (puntos de vida y destreza)
        do {
            System.out.println("Introduce los puntos de vida del personaje.");
            puntosVida = scanner.nextLine();
            System.out.println("Introduce la destreza del personaje.");
            destreza = scanner.nextLine();
        } while (puntosVida.matches("(a-zA-Z)*") || destreza.matches("(a-zA-Z)*"));

        //Creo el personaje segun la eleccion del usuario
        switch (personaje) {
            case 1: //CREAR CAZADOR
                System.out.println("\nDatos del CAZADOR.\n\n");
                p = crearCazador(Integer.parseInt(puntosVida), Integer.parseInt(destreza));
                break;
            case 2: //CREAR GUERRERO
                System.out.println("\nDatos del GUERRERO.\n\n");
                p = crearGuerrero(Integer.parseInt(puntosVida), Integer.parseInt(destreza));
                break;
            case 3: //CREAR MAGO
                System.out.println("\nDatos del MAGO.\n\n");
                p = crearMago(Integer.parseInt(puntosVida), Integer.parseInt(destreza));
                break;
        }
        return p;
    }

    private Cazador crearCazador(int pv, int destreza) {
        String energia, mana;

        System.out.println("Introduce los puntos de energia del personaje.");
        energia = scanner.nextLine();
        System.out.println("Introduce los puntos de mana del personaje.");
        mana = scanner.nextLine();

        Cazador c = new Cazador(pv, destreza, Integer.parseInt(energia), Integer.parseInt(mana));

        //Agregamos un arco al cazador
        incorporarArma(c, 1);

        return c;
    }

    private Guerrero crearGuerrero(int pv, int destreza) {
        String ira;

        System.out.println("Introduce los puntos de ira del personaje.");
        ira = scanner.nextLine();

        Guerrero g = new Guerrero(pv, destreza, Integer.parseInt(ira));

        //Agregamos una espada al guerrero
        incorporarArma(g, 2);

        return g;
    }

    private Mago crearMago(int pv, int destreza) {
        String mana;

        System.out.println("Introduce los puntos de mana del personaje.");
        mana = scanner.nextLine();

        Mago m = new Mago(pv, destreza, Integer.parseInt(mana));

        //Agregamos un baston al mago
        incorporarArma(m, 3);

        return m;
    }

    private void incorporarArma(Personaje p, int i) {
        //Agregamos un arma al jugador
        Arma arma = null;
        
        arma = factoriaArmas.crearArma(i); //1 = CrearArco, 2 = CrearEspada, 3 = CrearBaston
        p.tomarArma(arma); //Se guarda el arma en el inventario
        p.seleccionarArma(arma.getNombre()); //Se pone en la mano del personaje
        System.out.println("El arma se ha añadido al inventario y se ha puesto en tu mano.");
    }
}
