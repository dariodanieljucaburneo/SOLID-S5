package juego.modelo;

import java.util.Random;

public class Arquero extends Personaje {

    private static final String[] nombres = {
        "Legolas", "Robin", "Artemis", "Hawkeye", "GreenArrow",
        "Sylvanas", "Alleria", "Tyrande", "Varus", "Vayne"
    };

    private static final String[] ataques = {
        "flecha rapida",
        "disparo preciso",
        "flecha penetrante",
        "tiro certero",
        "lluvia de flechas",
        "disparo veloz",
        "impacto letal",
        "tiro doble",
        "flecha mortal",
        "disparo critico"
    };

    public Arquero() {

        super(
            nombres[new Random().nextInt(nombres.length)],
            95,
            20,
            5,
            "Arquero",
            new Objeto[]{
                new Arma("Arco Corto", 15),
                new Arma("Arco Largo", 45),
                new Armadura("Capucha de cuero", 10),
                new Armadura("Chaqueta de caza", 40)
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

        return ataque + 7 + extra;
    }

    @Override
    protected int habilidadEspecial() {

        int extra = 0;

        if (estado.equals("Aumentar Fuerza")) {
            extra = 10;
        }

        return ataque + 25 + extra;
    }

    @Override
    public String nombreHabilidad() {
        return "Flecha Letal";
    }

    @Override
    public void aplicarEstadoEspecial(Personaje objetivo) {
        objetivo.aplicarEstado("Envenenado");
    }
}