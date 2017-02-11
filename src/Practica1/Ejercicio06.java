package Practica1;

public class Ejercicio06 {

    /*
     * Explique lo que hace el siguiente c�digo; para ello utilice el depurador
     * como ayuda �C�mo se consigue parar la ejecuci�n de este c�digo dentro de
     * NetBeans? �Por qu� aparece el valor -2147483648?
     */

    public static void main(String[] args) {
        int i = 0, P1;

        while (true) {
            /* Loop forever */
            if (i == 0) {
                i = 1;
            } else {
                i = i << 1;
            }

            P1 = i;

            for (int j = 0; j < 0xFFFF; j++) {
                for (int k = 0; k < 0x4; k++);
            }
            System.out.println(i);
        }
    }
}
