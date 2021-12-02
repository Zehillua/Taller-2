package Dominio;

public class AsignaturaOp extends Asignatura{

    private int creditosPre;


    public AsignaturaOp(int codigo, String nombre, int creditos, String tipo, int creditosPre) {
        super(codigo, nombre, creditos, tipo);
        this.creditosPre = creditosPre;
    }


    public int getCreditosPre() {
        return creditosPre;
    } 
    
}
