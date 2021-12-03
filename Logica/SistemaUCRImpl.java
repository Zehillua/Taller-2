package Logica;
import Dominio.*;
import java.util.*;
public class SistemaUCRImpl implements SistemaUCR {
    
    private ListaAlumnos lAlumnos;
    private ListaEgresados lEgresados;
    private ListaAsignaturas lAsignaturas;
    private ListaParalelos lParalelos;
    private ListaProfesores lProfesores;
    private ListaCodigos lCodigos;
    private ListaAsignaturasE lAsignaturasE;
    private ListaAsignaturasIE lAsignaturasIE;

    public SistemaUCRImpl(){

        lAlumnos = new ListaAlumnos(10000);
        lEgresados = new ListaEgresados(10000);
        lAsignaturas = new ListaAsignaturas(10000);
        lParalelos = new ListaParalelos(10000);
        lProfesores = new ListaProfesores(10000);
        lCodigos = new ListaCodigos(1000);
        lAsignaturasE = new ListaAsignaturasE(1000);
        lAsignaturasIE = new ListaAsignaturasIE(1000);
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
        for(int i=0;i<lParalelos.getCant();i++){
            Paralelo p = lParalelos.getParaleloI(i);
            if(a!=null){ 
                if(p.getParalelo() == aIE.getParalelo()){
                    p.getListaAl().addAlumno(a);
                }
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
    public void IngresarAsignaturaOb(int codigo, String nombre, int creditos, String tipo, int nivelMalla, int cantAsPre) {
            AsignaturaOb aOB = new AsignaturaOb(codigo, nombre, creditos, tipo, nivelMalla, cantAsPre);
            if(!lAsignaturas.addAsignatura(aOB)){
                throw new NullPointerException("Error al ingresar una asignatura obligatoria.");
            }
        
    }

    @Override
    public void agregarCodigosAsOb(String nombre, int codigoPre) {
        CodigoAsignaturas cA = new CodigoAsignaturas(codigoPre);
        for(int i=0;i<lAsignaturas.getCant();i++){
            Asignatura a = lAsignaturas.getAsignaturaI(i);
            if(a instanceof AsignaturaOb){
                AsignaturaOb aOB = (AsignaturaOb) a;
                if(aOB.getNombre().equals(nombre)){
                    aOB.getListaCodigos().addCodigos(cA);
                }
            }
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
    public void cantAsignaturaInscrita(String rut, int cantAI) {
        Alumno a = lAlumnos.buscarAlumnoR(rut);
        if(a!=null){
            a.setCantAI(cantAI);
        }
        
    }

    @Override
    public String archivoEgresados() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void chequeoAlumno(String correo) {
        Profesor p = lProfesores.buscaProfesor(correo);
        for(int i=0;i<lParalelos.getCant();i++){
            Paralelo pA = lParalelos.getParaleloI(i);
            if(pA.getRutP().equals(p.getRutP())){
                System.out.println(pA.getParalelo());

            }
        }
        
    }

    @Override
    public void chequeoAlumno2(String correo, int paralelo) {
        Profesor p = lProfesores.buscaProfesor(correo);
        for(int i=0;i<lParalelos.getCant();i++){
            Paralelo pA = lParalelos.getParaleloI(i);
            if(pA.getRutP().equals(p.getRutP())){
                for(int j=0;j<pA.getListaAl().getCant();j++){
                    Alumno a = lAlumnos.getAlumnoI(j);
                    System.out.println("Rut: "+a.getRutA()+"\nCorreo: "+a.getCorreoA());
                }
            }   
        }

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
    public String inscripcionAsignatura(String correo) {
        String salida = "";
        Alumno a = lAlumnos.buscarAlumnoC(correo);
        for(int i=0;i<lAsignaturas.getCant();i++){
            Asignatura as = lAsignaturas.getAsignaturaI(i);
            if(as instanceof AsignaturaOb){
                AsignaturaOb aOb = (AsignaturaOb) as;
                if(a.getCreditos()+aOb.getCreditos()<=40 && a.getNivel()>=aOb.getNivelMalla()){
                    System.out.println("Asignatura: "+aOb.getNombre()+"\nCodigo: "+aOb.getCodigo()+"\n");
                    
                }
            }
        }
        return salida;
    }

    @Override
    public void inscripcionAsignatura2(int codigo) {
        for(int i=0;i<lAsignaturas.getCant();i++){
            Asignatura a = lAsignaturas.getAsignaturaI(i);
            if(a.getCodigo() == codigo){
                for(int j=0;j<lParalelos.getCant();j++){
                    Paralelo p = lParalelos.getParaleloI(i);
                    if(p.getCodigo() == codigo){
                        System.out.println("Paralelo: "+p.getParalelo());
                    }
                }
            }
        }
        
    }

    @Override
    public void notaFinal(String correo) {
        Profesor p = lProfesores.buscaProfesor(correo);
        for(int i=0;i<p.getListaAs().getCant();i++){
            Asignatura a = lAsignaturas.getAsignaturaI(i);
            System.out.println("Asignatura: "+a.getNombre()+" Codigo: "+a.getCodigo());
        }        
    }    

    @Override
    public void notaFinal2(String correo, int codigo) {
        Asignatura a = lAsignaturas.buscarAsignaturaC(codigo);
        for(int i=0;i<a.getListaA().getCant();i++){
            Alumno al = lAlumnos.getAlumnoI(i);
            System.out.println("Alumno: "+al.getRutA());
        }
        
    }

    @Override
    public void notaFinal3(String rut, int codigo) {
        Scanner scan = new Scanner(System.in);
        Alumno a = lAlumnos.buscarAlumnoR(rut);
        if(a!=null){
            System.out.println("Ingrese la nota del alumno: ");
            double notFinal = Double.parseDouble(scan.nextLine());
            AsignaturaEstudiante aE = a.getListaAE().buscaAsignaturaEstudiante(codigo);
            aE.setNotaFinal(notFinal);
        }
        
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
