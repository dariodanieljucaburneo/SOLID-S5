package juego.modelo;

import java.util.Random;

public class Guerrero extends Personaje {

    private static final String[] nombres = {
        "Kratos", "Ares", "Leonidas", "Hector", "Conan",
        "Thor", "Maximus", "Spartacus", "Ajax", "Ragnar"
    };

    private static final String[] ataques = {
        "cabezaso fuerte",
        "golpe devastador",
        "espadazo brutal",
        "corte feroz",
        "embestida salvaje",
        "ataque pesado",
        "golpe de guerra",
        "choque violento",
        "fuerza titanica",
        "impacto demoledor"
    };

    public Guerrero() {
        super(
            nombres[new Random().nextInt(nombres.length)],
            100,
            15,
            10,
            "Guerrero",
            new Objeto[]{
                new Arma("Espada corta", 15),
                new Arma("Espada larga", 25),
                new Armadura("Casco", 15),
                new Armadura("Guanteletes", 10)
            }[new Random().nextInt(4)]
        );

        Random r = new Random();
        this.nombreAtaque = ataques[r.nextInt(ataques.length)];
    }

    @Override
    public int atacar() {

        int extra = 0;

        if (estado.equals("Aumentar Fuerza")) {
            extra = 10;
        }

        return ataque + 5 + extra;
    }

    @Override
    protected int habilidadEspecial() {

        int extra = 0;

        if (estado.equals("Aumentar Fuerza")) {
            extra = 10;
        }

        return ataque + 20 + extra;
    }

    @Override
    public String nombreHabilidad() {
        return "Golpe Brutal";
    }

    @Override
    public void aplicarEstadoEspecial(Personaje objetivo) {
        this.aplicarEstado("Aumentar Fuerza");
    }
}