package Dominio;
import Logica.*;

public class Paralelo {
    
    private int paralelo;
    private int codigo;
    private String rutP;
    private ListaAlumnos listaAl;


    public Paralelo(int paralelo, int codigo, String rutP) {
        this.paralelo = paralelo;
        this.codigo = codigo;
        this.rutP = rutP;
        listaAl = new ListaAlumnos(100);
    }

    public int getParalelo() {
        return paralelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getRutP() {
        return rutP;
    }

    public ListaAlumnos getListaAl() {
        return listaAl;
    }

}
