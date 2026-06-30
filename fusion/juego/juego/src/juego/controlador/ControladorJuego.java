package juego.controlador;

import juego.modelo.*;
import juego.vista.VistaCombate;
import java.util.Random;
import java.util.Scanner;

public class ControladorJuego {

    public void run() {

        Scanner sc = new Scanner(System.in);
        VistaCombate vista = new VistaCombate();
        Random rand = new Random();

        int opcion;

        do {

            System.out.println("\n==== MENU ====");
            System.out.println("1. Iniciar combate");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    Personaje[] personajes = {
                        new Guerrero(),
                        new Mago(),
                        new Arquero()
                    };

                    Personaje p1 =
                            personajes[rand.nextInt(personajes.length)];

                    Personaje p2 =
                            personajes[rand.nextInt(personajes.length)];

                    while (p1 == p2) {
                        p2 = personajes[rand.nextInt(personajes.length)];
                    }

                    p1.resetearEstado();
                    p2.resetearEstado();

                    vista.mostrarEstado(p1, p2);

                    Combate combate = new Combate();

                    Personaje ganador =
                            combate.pelear(p1, p2);

                    vista.mostrarEstado(p1, p2);

                    vista.mostrarGanador(ganador);

                    break;

                case 2:

                    System.out.println(
                            "\nGracias por jugar. Hasta pronto."
                    );

                    break;

                default:

                    System.out.println(
                            "\nOpcion invalida. Intente nuevamente."
                    );
            }

        } while (opcion != 2);

        sc.close();
    }
}