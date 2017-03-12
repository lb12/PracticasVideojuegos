package Practica4.factories;

import Practica4.armas.*;
import java.util.Scanner;

public class ArmasFactory {

    private Scanner scanner = new Scanner(System.in);

    public Arma crearArma(int tipoArma) {

        Arma arma = null;
        String nombre, danyo;

        //Pido los atributos basicos del arma (nombre y danyo)
        System.out.println("\nIntroduce el nombre del arma.");
        nombre = scanner.nextLine();
        do {
            System.out.println("\nIntroduce el daño infligido por el arma.");
            danyo = scanner.nextLine();
        } while (danyo.matches("(a-zA-Z)*"));

        //Creo el tipo de arma segun el usuario
        switch (tipoArma) {
            case 1: //CREAR ARCO
                //System.out.println("\nDatos del ARCO.\n\n");
                arma = crearArco(nombre, Integer.parseInt(danyo));
                break;
            case 2: //CREAR ESPADA
                //System.out.println("\nDatos de la ESPADA.\n\n");
                arma = crearEspada(nombre, Integer.parseInt(danyo));
                break;
            case 3: //CREAR BASTON
                //System.out.println("\nDatos del BASTÓN.\n\n");
                arma = crearBaston(nombre, Integer.parseInt(danyo));
                break;
        }

        return arma;
    }

    private Arco crearArco(String nombre, int danyo) {
        String capacidad;

        do {
            System.out.println("Introduce la capacidad del carcaj del arco.");
            capacidad = scanner.nextLine();
        } while (capacidad.matches("[a-zA-Z]*"));

        return new Arco(nombre, danyo, Integer.parseInt(capacidad));
    }

    private Espada crearEspada(String nombre, int danyo) {
        String resistencia;

        do {
            System.out.println("Introduce la resistencia de la espada.");
            resistencia = scanner.nextLine();
        } while (resistencia.matches("[a-zA-Z]*"));

        return new Espada(nombre, danyo, Integer.parseInt(resistencia));
    }

    private Baston crearBaston(String nombre, int danyo) {
        String puntosMagia;

        do {
            System.out.println("Introduce los puntos de magia que tiene el bastón.");
            puntosMagia = scanner.nextLine();
        } while (puntosMagia.matches("[a-zA-Z]*"));

        return new Baston(nombre, danyo, Integer.parseInt(puntosMagia));
    }
}
