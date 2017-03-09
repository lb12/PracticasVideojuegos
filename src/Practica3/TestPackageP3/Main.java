package Practica3.TestPackageP3;

import Practica3.armas.*;
import Practica3.personajes.*;

public class Main {

    public static void main(String[] args) {

        //ARMAS
        Espada espada = new Espada("Espada afilada", 10, 60);
        Arco arco = new Arco("Muerte sangrienta", 8, 300);
        Baston baston = new Baston("Sabelotodo", 9, 200);

        /* //Mostrar las armas
        Arma[] armas = {espada, arco, baston};         
        for (int i = 0; i < armas.length; i++) {
            System.out.println(armas[i].toString());
        }
         */
        //PERSONAJES
        Personaje hunter = new Cazador("Hunter", 105, 6, arco, 100, 110);
        Personaje warrior = new Guerrero("Warrior", 110, 7, espada, 120);
        Personaje mage = new Mago("Mage", 80, 5, baston, 220);

        /* //Mostrar los personajes
        Personaje[] personajes = {hunter, warrior, mage};        
        for (int i = 0; i < personajes.length; i++) {
            System.out.println(personajes[i].toString());
        }
         */
        //Combates entre personajes
        //hunter.combatir(mage);
        warrior.combatir(hunter);
        //mage.combatir(warrior);
    }
}
