
package juego.modelo;

public abstract class Objeto {
    protected String nombre, tipo;
    protected int atq, def;

    public Objeto(String nombre, String tipo, int atq, int def) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.atq = atq;
        this.def = def;
    }

    public int getAtq() {
        return atq;
    }

    public int getDef() {
        return def;
    }

    public String getNombre() {
        return nombre;
    }    

    public String getTipo() {
        return tipo;
    }
}
