package Dominio;
import Logica.*;

public class Alumno {
    
    private String rutA;
    private String correoA;
    private int nivel;
    private String contraseñaA;
    private int creditos;
    private int cantA;
    private int cantAI;
    private ListaAsignaturasE listaAE;
    private ListaAsignaturasIE listaIE;


    public Alumno(String rutA, String correoA, int nivel, String contraseñaA, int creditos, int cantA ,int cantAI) {
        this.rutA = rutA;
        this.correoA = correoA;
        this.nivel = nivel;
        this.contraseñaA = contraseñaA;
        this.creditos = creditos;
        this.cantA = cantA;
        this.cantAI = cantAI;
        listaAE = new ListaAsignaturasE(1000);
        listaIE = new ListaAsignaturasIE(1000);
    }

    public String getRutA() {
        return rutA;
    }

    public String getCorreoA() {
        return correoA;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    public String getContraseñaA() {
        return contraseñaA;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCantA(){
        return cantA;
    }

    public void setCantA(int cantA){
        this.cantA = cantA;
    }

    public int getCantAI() {
        return cantAI;
    }

    public void setCantAI(int cantAI) {
        this.cantAI = cantAI;
    }

    public ListaAsignaturasE getListaAE(){
        return listaAE;
    }

    public ListaAsignaturasIE getListaIE(){
        return listaIE;
    }
}
