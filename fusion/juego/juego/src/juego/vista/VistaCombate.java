package juego.vista;

import juego.modelo.Personaje;

public class VistaCombate {

    public void mostrarEstado(Personaje p1, Personaje p2) {

        System.out.println("\n=== ESTADO ACTUAL ===");

        mostrarPersonaje(p1);
        mostrarPersonaje(p2);
    }

    private void mostrarPersonaje(Personaje p) {

        System.out.println(
            p.getNombre() +
            " | Vida: " + p.getVida() +
            " | Estado: " + p.getEstado() +
            " | Cooldown: " + p.getCooldown()
        );
    }

    public void mostrarAtaque(Personaje p, int danio) {

        System.out.println(
            p.getNombre() +
            " ataca usando " +
            p.getNombreAtaque() +
            " con " +
            danio +
            " puntos de danio"
        );
    }

    public void mostrarHabilidad(Personaje p, int danio) {

        System.out.println(
            p.getNombre() +
            " usa " +
            p.nombreHabilidad() +
            " con " +
            danio
        );
    }

    public void mostrarEstadoAplicado(Personaje p, String estado) {

        System.out.println(
            p.getNombre() +
            " ahora esta: " +
            estado
        );
    }

    public void mostrarVida(Personaje p) {

        System.out.println(
            "Vida de " +
            p.getNombre() +
            ": " +
            p.getVida()
        );
    }

    public void mostrarGanador(Personaje p) {

        System.out.println("\n=== RESULTADO FINAL ===");

        if (p == null) {

            System.out.println("Resultado: EMPATE");

        } else {

            System.out.println(
                "GANADOR: " +
                p.getNombre()
            );
        }
    }
}