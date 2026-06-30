package juego.vista;

import juego.controlador.ControladorJuego;

public class EjecutarJuego {

    public static void main(String[] args) {

        ControladorJuego juego = new ControladorJuego();

        juego.run();
    }
}