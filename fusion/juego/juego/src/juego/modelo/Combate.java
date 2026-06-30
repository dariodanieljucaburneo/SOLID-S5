package juego.modelo;

public class Combate {

    public Personaje pelear(Personaje p1, Personaje p2) {

        System.out.println("\n--- COMBATE ---");
        System.out.println(p1);
        System.out.println(p2);

        while (p1.getVida() > 0 && p2.getVida() > 0) {

            String e1 =
                (p1.getCooldown() == 0)
                ? "HABILIDAD CARGADA"
                : "EN ESPERA";

            String e2 =
                (p2.getCooldown() == 0)
                ? "HABILIDAD CARGADA"
                : "EN ESPERA";

            System.out.println("\nEstado:");

            System.out.println(
                p1.getNombre()
                + " | "
                + e1
                + " | Estado: "
                + p1.getEstado()
            );

            System.out.println(
                p2.getNombre()
                + " | "
                + e2
                + " | Estado: "
                + p2.getEstado()
            );
            if (!p1.aplicarEfectosEstado()) {

                p1.reducirCooldown();

            } else {

                int d1;

                try {

                    if (p1.getCooldown() == 0) {

                        d1 = p1.usarHabilidadEspecial();

                        System.out.println(
                            p1.getNombre()
                            + " usa "
                            + p1.nombreHabilidad()
                            + " con "
                            + d1
                        );

                    } else {

                        d1 = p1.atacar();

                        System.out.println(
                            p1.getNombre()
                            + " ataca usando "
                            + p1.getNombreAtaque()
                            + " con "
                            + d1
                            + " puntos de danio"
                        );
                    }

                } catch (Exception e) {

                    d1 = p1.atacar();

                    System.out.println(
                        p1.getNombre()
                        + " ataca usando "
                        + p1.getNombreAtaque()
                        + " con "
                        + d1
                        + " puntos de danio"
                    );
                }

                p2.defender(d1);

                System.out.println(
                    "Vida de "
                    + p2.getNombre()
                    + ": "
                    + p2.getVida()
                );

                p1.aplicarEstadoEspecial(p2);
                if (p1.getVida() <= 0 && p2.getVida() <= 0) {
                    return null;
                }

                if (p2.getVida() <= 0) {
                    return p1;
                }
            }

            if (!p2.aplicarEfectosEstado()) {

                p2.reducirCooldown();

            } else {

                int d2;

                try {

                    if (p2.getCooldown() == 0) {

                        d2 = p2.usarHabilidadEspecial();

                        System.out.println(
                            p2.getNombre()
                            + " usa "
                            + p2.nombreHabilidad()
                            + " con "
                            + d2
                        );

                    } else {

                        d2 = p2.atacar();

                        System.out.println(
                            p2.getNombre()
                            + " ataca usando "
                            + p2.getNombreAtaque()
                            + " con "
                            + d2
                            + " puntos de danio"
                        );
                    }

                } catch (Exception e) {

                    d2 = p2.atacar();

                    System.out.println(
                        p2.getNombre()
                        + " ataca usando "
                        + p2.getNombreAtaque()
                        + " con "
                        + d2
                        + " puntos de danio"
                    );
                }

                p1.defender(d2);

                System.out.println(
                    "Vida de "
                    + p1.getNombre()
                    + ": "
                    + p1.getVida()
                );

                p2.aplicarEstadoEspecial(p1);


                if (p1.getVida() <= 0 && p2.getVida() <= 0) {
                    return null;
                }

                if (p1.getVida() <= 0) {
                    return p2;
                }
            }

            p1.reducirCooldown();
            p2.reducirCooldown();
        }

        return null;
    }
}