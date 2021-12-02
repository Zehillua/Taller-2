package Logica;
import Dominio.*;
import java.util.*;
public class SistemaUCRImpl implements SistemaUCR {
    
    private ListaAlumnos lAlumnos;
    private ListaEgresados lEgresados;
    private ListaAsignaturas lAsignaturas;
    private ListaParalelos lParalelos;
    private ListaProfesores lProfesores;

    public SistemaUCRImpl(){

        lAlumnos = new ListaAlumnos(10000);
        lEgresados = new ListaEgresados(10000);
        lAsignaturas = new ListaAsignaturas(10000);
        lParalelos = new ListaParalelos(10000);
        lProfesores = new ListaProfesores(10000);
    }

    @Override
    public void IngresarAlumno(String rutA, String correoA, int nivel, String contraseñaA, int creditos, int cantA ,int cantAI) {
        Alumno a = new Alumno(rutA, correoA, nivel, contraseñaA, creditos, cantA, cantAI);
        if(!lAlumnos.addAlumno(a)){
            throw new NullPointerException("Error al ingresar un estudiante.");
        }
        
    }

    @Override
    public void IngresarAsignaturEstudiante(int codigo, double notaFinal, String rut) {
        AsignaturaEstudiante aE = new AsignaturaEstudiante(codigo, notaFinal);
        Alumno a = lAlumnos.buscarAlumnoR(rut);
        if(a != null){
            if(!a.getListaAE().addAsignaturaE(aE)){
                throw new NullPointerException("Error al ingresar una asignatura de un estudiante");
            }
            
        }
        
    }

    @Override
    public void IngresarAsignaturaIEstudiante(int codigo, int paralelo, String rut) {
        AsignaturaIEstudiante aIE = new AsignaturaIEstudiante(codigo, paralelo);
        Alumno a = lAlumnos.buscarAlumnoR(rut);
        if(a!=null){
            if(!a.getListaIE().addAsignaturaE(aIE)){
                throw new NullPointerException("Error al ingresar una asignatura inscrita de un estudiante.");
            }
            
        }
        
    }

    @Override
    public void IngresarAlumnoE(String rutE) {
        AlumnoE aE = new AlumnoE(rutE);
        if(!lEgresados.addAlumnoE(aE)){
            throw new NullPointerException("Error al ingresar el estudiante egresado.");
        }
        
    }

    @Override
    public void IngresarAsignaturaOb(int codigo, String nombre, int creditos, String tipo, int nivelMalla,
            int cantAsPre, int codigoPre) {
            AsignaturaOb aOB = new AsignaturaOb(codigo, nombre, creditos, tipo, nivelMalla, cantAsPre, codigoPre);
            if(!lAsignaturas.addAsignatura(aOB)){
                throw new NullPointerException("Error al ingresar una asignatura obligatoria.");
            }
        
    }

    @Override
    public void IngresarAsignaturaOp(int codigo, String nombre, int creditos, String tipo, int creditosPre) {
        AsignaturaOp aOP = new AsignaturaOp(codigo, nombre, creditos, tipo, creditosPre);
        if(!lAsignaturas.addAsignatura(aOP)){
            throw new NullPointerException("Error al ingresar una asignatura opcional.");
        }
        
    }

    @Override
    public void IngresarParalelo(int paralelo, int codigo, String rutP) {
        Paralelo p = new Paralelo(paralelo, codigo, rutP);
        if(!lParalelos.addParalelo(p)){
            throw new NullPointerException("Error al ingresar un paralelo.");
        }
        
    }

    @Override
    public void IngresarProfesor(String rutP, String correoP, String contraseñaP, int salario) {
        Profesor p = new Profesor(rutP, correoP, contraseñaP, salario);
        if(!lProfesores.addProfesor(p)){
            throw new NullPointerException("Error al ingresar un profesor.");
        }
        
    }

    @Override
    public String archivoEgresados() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void chequeoAlumno(String correo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean confirmarContraseña(String correo, String contraseña) {
        boolean conf = false;
        if(confirmarCorreo2(correo)==1){
            Alumno a = lAlumnos.buscarAlumnoC(correo);
            conf = a.getContraseñaA().equals(contraseña);
        }
        if(confirmarCorreo2(correo)==2){
            Profesor p = lProfesores.buscaProfesor(correo);
            conf = p.getContraseñaP().equals(contraseña);
        }
        return conf;
    }

    @Override
    public boolean confirmarCorreoA(String correo) {
        Alumno a = lAlumnos.buscarAlumnoC(correo);
        return a!=null;
    }

    @Override
    public boolean confirmarCorreoP(String correo) {
        Profesor p = lProfesores.buscaProfesor(correo);
        return p!=null;
    }

    @Override
    public int confirmarCorreo2(String correo) {
        if(confirmarCorreoA(correo)){
            return 1;
        }
        if(confirmarCorreoP(correo)){
            return 2;
        }
        if(correo.equals("Admin")){
            return 3;
        }else{
           throw new NullPointerException("El correo no se encuentra en el sistema.");
        }
        
    }

    @Override
    public void eliminarAsignatura(String correo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inscripcionAsignatura(String correo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void notaFinal(String correo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String sobreescrituraAlumnos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String sobreescrituraAsignaturas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String sobreescrituraParalelos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String sobreescrituraProfesores() {
        // TODO Auto-generated method stub
        return null;
    }


    
}
