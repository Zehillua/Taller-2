package Dominio;

import Logica.ListaAsignaturas;
import Logica.ListaCodigos;

public class AsignaturaOb extends Asignatura {

    private int nivelMalla;
    private int cantAsPre;
    private ListaCodigos listaCodigos;
    
    public AsignaturaOb(int codigo, String nombre, int creditos, String tipo, int nivelMalla, int cantAsPre) {
        super(codigo, nombre, creditos, tipo);
        this.nivelMalla = nivelMalla;
        this.cantAsPre = cantAsPre;
        listaCodigos = new ListaCodigos(10);
    }


    public int getNivelMalla() {
        return nivelMalla;
    }

    public int getCantAsPre() {
        return cantAsPre;
    }

    public ListaCodigos getListaCodigos(){
        return listaCodigos;
    }
}
