package model;


abstract public class Treino {
    private String nivel;
    private String dia = "A";

    public Treino(String nivel) {
        this.nivel = nivel;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
