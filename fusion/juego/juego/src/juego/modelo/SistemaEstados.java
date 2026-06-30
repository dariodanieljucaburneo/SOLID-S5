package juego.modelo;

public class SistemaEstados {

    public void aplicarEstado(Personaje atacante, Personaje objetivo) {

        double r = Math.random();

        if (atacante instanceof Mago) {
            if (r < 0.5) {
                objetivo.aplicarEstado("Quemado");
            } else {
                objetivo.aplicarEstado("Congelado");
            }
        } else if (atacante instanceof Arquero) {
            objetivo.aplicarEstado("Envenenado");
        } else if (atacante instanceof Guerrero) {
            atacante.aplicarEstado("Aumentar Fuerza");
        }
    }
}