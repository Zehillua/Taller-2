package Dominio;
import Logica.*;

public class Profesor {
    
    private String rutP;
    private String correoP;
    private String contraseñaP;
    private int salario;
    private ListaAsignaturas listaAs;


    public Profesor(String rutP, String correoP, String contraseñaP, int salario) {
        this.rutP = rutP;
        this.correoP = correoP;
        this.contraseñaP = contraseñaP;
        this.salario = salario;
        listaAs = new ListaAsignaturas(4);
    }

    public String getRutP() {
        return rutP;
    }

    public String getCorreoP() {
        return correoP;
    }

    public String getContraseñaP() {
        return contraseñaP;
    }

    public int getSalario() {
        return salario;
    }

    public ListaAsignaturas getListaAs() {
        return listaAs;
    }

}
