package Dominio;

public class AsignaturaOb extends Asignatura {

    private int nivelMalla;
    private int cantAsPre;
    private int codigoPre;

    
    public AsignaturaOb(int codigo, String nombre, int creditos, String tipo, int nivelMalla, int cantAsPre,
            int codigoPre) {
        super(codigo, nombre, creditos, tipo);
        this.nivelMalla = nivelMalla;
        this.cantAsPre = cantAsPre;
        this.codigoPre = codigoPre;
    }


    public int getNivelMalla() {
        return nivelMalla;
    }

    public int getCantAsPre() {
        return cantAsPre;
    }

    public int getCodigoPre() {
        return codigoPre;
    }

}
