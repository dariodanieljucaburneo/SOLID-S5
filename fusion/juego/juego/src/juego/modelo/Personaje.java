package juego.modelo;

public abstract class Personaje
        implements Atacante,
                   Defensor,
                   ConHabilidad,
                   GeneradorEstado {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected String tipo;

    protected int energia;
    protected int maxEnergia = 100;
    protected int cooldown = 0;

    protected String estado = "Normal";
    protected int turnosEstado = 0;

    protected Objeto obj;
    protected String nombreAtaque;

    public Personaje(String nombre,
                     int vida,
                     int ataque,
                     int defensa,
                     String tipo,
                     Objeto obj) {

        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque + obj.getAtq();
        this.defensa = defensa + obj.getDef();
        this.tipo = tipo;
        this.obj = obj;

        this.nivel = (int)(Math.random() * 100) + 1;
        this.energia = maxEnergia;
    }

    @Override
    public abstract int atacar();

    @Override
    public void defender(int danio) {

        int danioFinal = danio - defensa;

        if (danioFinal < 0) {
            danioFinal = 0;
        }

        vida -= danioFinal;

        if (vida < 0) {
            vida = 0;
        }
    }

    @Override
    public int usarHabilidadEspecial() throws Exception {

        if (energia < 20) {
            throw new Exception("Sin energia");
        }

        if (cooldown > 0) {
            throw new Exception("Habilidad en cooldown");
        }

        energia -= 20;
        cooldown = 2;

        return habilidadEspecial();
    }

    protected abstract int habilidadEspecial();

    @Override
    public abstract String nombreHabilidad();

    @Override
    public abstract void aplicarEstadoEspecial(Personaje objetivo);

    public void reducirCooldown() {

        if (cooldown > 0) {
            cooldown--;
        }
    }

    public boolean aplicarEfectosEstado() {

        if (estado.equals("Envenenado")) {

            vida -= 5;

            if (vida < 0) {
                vida = 0;
            }

            System.out.println(
                nombre + " sufre daño por veneno (-5 vida)"
            );
        }
        else if (estado.equals("Quemado")) {

            vida -= 3;

            if (vida < 0) {
                vida = 0;
            }

            System.out.println(
                nombre + " sufre daño por quemadura (-3 vida)"
            );
        }
        else if (estado.equals("Congelado")) {

            System.out.println(
                nombre + " esta congelado y pierde su turno"
            );

            turnosEstado--;

            if (turnosEstado <= 0) {
                resetearEstado();
            }

            return false;
        }

        if (estado.equals("Aumentar Fuerza")) {

            System.out.println(
                nombre + " esta fortalecido (+10 ataque)"
            );
        }

        turnosEstado--;

        if (turnosEstado <= 0 &&
            !estado.equals("Normal")) {

            resetearEstado();
        }

        return true;
    }

    public void aplicarEstado(String estado) {

        this.estado = estado;

        if (estado.equals("Congelado")) {
            turnosEstado = 1;
        } else {
            turnosEstado = 3;
        }
    }

    public void resetearEstado() {

        switch (tipo) {

            case "Guerrero":
                vida = 100;
                break;

            case "Mago":
                vida = 90;
                break;

            case "Arquero":
                vida = 95;
                break;
        }

        energia = maxEnergia;
        cooldown = 0;

        estado = "Normal";
        turnosEstado = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEnergia() {
        return energia;
    }

    public int getCooldown() {
        return cooldown;
    }

    public String getEstado() {
        return estado;
    }

    public String getNombreAtaque() {
        return nombreAtaque;
    }

    public Objeto getObjeto() {
        return obj;
    }

    @Override
    public String toString() {

        return nombre + " [" + tipo + "]" +
               " | Vida: " + vida +
               " | Nivel: " + nivel +
               " | Ataque: " + ataque +
               " | Defensa: " + defensa +
               " | Energia: " + energia +
               " | Objeto: " + obj.getNombre() +
               " [" + obj.getTipo() + "]";
    }
}