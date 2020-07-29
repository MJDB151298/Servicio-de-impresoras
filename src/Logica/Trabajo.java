package Logica;

public class Trabajo {
    private String texto;
    private String tipo;

    public Trabajo(String texto, String tipo){
        this.texto = texto;
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
