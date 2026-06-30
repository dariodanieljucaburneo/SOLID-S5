package juego.modelo;

import java.util.Random;

public class Mago extends Personaje {

    private static final String[] nombres = {
        "Gandalf", "Merlin", "Saruman", "Dumbledore", "Morgana",
        "Zatanna", "Rincewind", "Elminster", "Raistlin", "Prospero"
    };

    private static final String[] ataques = {
        "bola de fuego",
        "rayo magico",
        "explosion arcana",
        "descarga mistica",
        "chispa oscura",
        "hechizo elemental",
        "luz divina",
        "energia arcana",
        "impacto magico",
        "pulso de mana"
    };

    public Mago() {

        super(
            nombres[new Random().nextInt(nombres.length)],
            90,
            20,
            5,
            "Mago",
            new Objeto[]{
                new Arma("Baston", 50),
                new Arma("Varita", 15),
                new Armadura("Toga", 5),
                new Armadura("Tunica", 20)
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

        return ataque + 10 + extra;
    }

    @Override
    protected int habilidadEspecial() {

        int extra = 0;

        if (estado.equals("Aumentar Fuerza")) {
            extra = 10;
        }

        return ataque + 30 + extra;
    }

    @Override
    public String nombreHabilidad() {
        return "Hechizo Arcano";
    }

    @Override
    public void aplicarEstadoEspecial(Personaje objetivo) {

        if (Math.random() < 0.5) {
            objetivo.aplicarEstado("Quemado");
        } else {
            objetivo.aplicarEstado("Congelado");
        }
    }
}