package Dominio;
import Logica.*;

public abstract class Asignatura {
    
    private int codigo;
    private String nombre;
    private int creditos;
    private String tipo;
    ListaAlumnos listaA;


    public Asignatura(int codigo, String nombre, int creditos, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.tipo = tipo;
        listaA = new ListaAlumnos(10000);
    }


    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public ListaAlumnos getListaA() {
        return listaA;
    }

    
}
