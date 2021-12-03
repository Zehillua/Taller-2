package Logica;
import Dominio.*;
import java.util.*;
import java.io.*;

public class App {

    public static void main(String args [])throws IOException {
        SistemaUCR sistema = new SistemaUCRImpl();
        LecturaAsignaturas(sistema);
        LecturaParalelos(sistema);
        LecturaProfesores(sistema);
        LecturaEstudiantes(sistema);
        inicioSesion(sistema);
    }
    

    /**
     * Read the estudiantes.txt file.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     */
    public static void LecturaEstudiantes(SistemaUCR sistema){
        try {
            Scanner scan = new Scanner(new File("estudiantes.txt"));
            String rut = "";
            String correo = "";
            int nivel = 0;
            String password = "";
            int cant = 0;
            int creditos = 0;
            int cantAsignaturaI = 0;
            boolean cursadas = false;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                String[] partes = linea.split(",");
                if (partes.length > 1) {
                    if (partes.length == 2) {
                        if (cursadas) {
                            int codAsignatura = Integer.parseInt(partes[0]);
                            double notaFinal = Double.parseDouble(partes[1]);
                            sistema.IngresarAsignaturEstudiante(codAsignatura, notaFinal, rut);
                        } else {
                            int codAsignaturaI = Integer.parseInt(partes[0]);
                            int paralelo = Integer.parseInt(partes[1]);
                            sistema.IngresarAsignaturaIEstudiante(codAsignaturaI, paralelo, rut);
                        }
                    } else {
                        rut = partes[0];
                        correo = partes[1];
                        nivel = Integer.parseInt(partes[2]);
                        password = partes[3];
                    }
                }
                else {
                    if (partes.length == 1) {
                        if (!cursadas) {
                            int cantAsignatura = Integer.parseInt(partes[0]);
                            Alumno a = new Alumno(rut, correo, nivel, password, creditos, cantAsignatura, cantAsignaturaI);
                            a.setCantA(cantAsignatura);                        
                            sistema.IngresarAlumno(rut, correo, nivel, password, creditos, cantAsignatura, cantAsignaturaI);
                            //
                            cursadas = true;
                        } else {
                            cantAsignaturaI = Integer.parseInt(partes[0]);
                            sistema.cantAsignaturaInscrita(rut, cantAsignaturaI);
                            cursadas = false;
                        }
                        
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Read the profesores.txt file.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     */
    public static void LecturaProfesores(SistemaUCR sistema){
        try{ 
            Scanner scan = new Scanner(new File("profesores.txt"));
            while(scan.hasNextLine()){
                String linea = scan.nextLine();
                String [] partes = linea.split(",");
                String rut = partes[0];
                String correo = partes[1];
                String contraseña = partes[2];
                int salario = Integer.parseInt(partes[3]);
                try{ 
                    sistema.IngresarProfesor(rut, correo, contraseña, salario);
                }catch(NullPointerException e){
                    System.out.println(e.getMessage());
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Read the paralelos.txt file.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     */
    public static void LecturaParalelos(SistemaUCR sistema){
        try{ 
            Scanner scan = new Scanner(new File("paralelos.txt"));
            while(scan.hasNextLine()){
                String linea = scan.nextLine();
                String [] partes = linea.split(",");
                int paralelo = Integer.parseInt(partes[0]);
                int codigo = Integer.parseInt(partes[1]);
                String rutP = partes[2];
                sistema.IngresarParalelo(paralelo, codigo, rutP);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Read the asignaturas.txt file.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     */
    public static void LecturaAsignaturas(SistemaUCR sistema){
        try{ 
            Scanner scan = new Scanner(new File("asignaturas.txt"));
            while(scan.hasNextLine()){
                String linea = scan.nextLine();
                String [] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int creditos = Integer.parseInt(partes[2]);
                String tipo = partes[3];
                if(tipo.equals("obligatoria")){
                    int nivelMalla = Integer.parseInt(partes[4]);
                    int cantAsPre = Integer.parseInt(partes[5]);
                    sistema.IngresarAsignaturaOb(codigo, nombre, creditos, tipo, nivelMalla, cantAsPre);
                    for(int i=6;i<partes.length;i++){
                        int codigoPre = Integer.parseInt(partes[i]);
                        sistema.agregarCodigosAsOb(nombre, codigoPre);
                    }
                }else{
                    int creditosPre = Integer.parseInt(partes[4]);
                    sistema.IngresarAsignaturaOp(codigo, nombre, creditos, tipo, creditosPre);
                }
         }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * The inicioSesion method is created to log into the system.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     */
    public static void inicioSesion(SistemaUCR sistema){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al menu de la UCR");
        System.out.println("Ingrese su correo: ");
        String correo = scan.nextLine();
        int validarCorreo = sistema.confirmarCorreo2(correo);
        
        if(validarCorreo==1){
            while(true){
                System.out.println("Ingrese su contraseña: ");
                String contraseña = scan.nextLine();
                if(sistema.confirmarContraseña(correo, contraseña)){
                    System.out.println("Ingrese el dia en el que esta iniciando sesion: ");
                    int dia = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese el mes: ");
                    int mes = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese el año: ");
                    int año = Integer.parseInt(scan.nextLine());
                    if(dia>=8 && mes == 3 && año ==2021 || dia >=1 && mes == 4 && año == 2021 || dia<=2 && mes == 5 && año==2021){
                        menuAlumnoInicio(sistema, correo);
                        break;
                    }
                    if(dia>=3 && mes == 5 && año==2021 || dia>=1 && mes == 6 && año == 2021 || dia<=11 && mes == 7 && año == 2021){
                        menuAlumnoMitad(sistema, correo);
                        break;
                    }
                    if(dia>=12 && dia<=25 && mes==7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia==26 && mes==7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    else{
                        System.out.println("Disfrute sus vacaciones.");
                        break;
                    }
                }else{
                    System.out.println("Contraseña incorrecta, ¿desea intentarlo nuevamente o cerrar el programa?");
                    System.out.println("Ingrese '1' si desea intentarlo otra vez o ingrese '2' si desea cerrar el programa: ");
                    int opcion = Integer.parseInt(scan.nextLine());
                    if(opcion == 2){
                        break;
                    }
                }
            }
        }
        if(validarCorreo==2){
            while(true){ 
                System.out.println("Ingrese su contraseña: ");
                String contraseña = scan.nextLine();
                if(sistema.confirmarContraseña(correo, contraseña)){
                    
                    System.out.println("Ingrese el dia en el que esta iniciando sesion: ");
                    int dia = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese el mes: ");
                    int mes = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese el año: ");
                    int año = Integer.parseInt(scan.nextLine());
                    if(dia>=8 && mes == 3 && año ==2021 || dia >=1 && mes == 4 && año == 2021 || dia<=2 && mes == 5 && año==2021){
                        menuProfesorInicio(sistema, correo);
                        break;
                    }
                    if(dia>=3 && mes == 5 && año==2021 || dia>=1 && mes == 6 && año == 2021 || dia<=11 && mes == 7 && año == 2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia>=12 && dia<=25 && mes==7 && año==2021){
                        menuProfesorFinal(sistema, correo);
                        break;
                    }
                    if(dia==26 && mes==7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    else{
                        System.out.println("Disfrute sus vacaciones.");
                        break;
                    }
                    

                
                }else{
                    System.out.println("Contraseña incorrecta, ¿desea intentarlo nuevamente o cerrar el programa?");
                    System.out.println("Ingrese '1' si desea intentarlo otra vez o ingrese '2' si desea cerrar el programa: ");
                    int opcion = Integer.parseInt(scan.nextLine());
                    if(opcion == 2){
                        break;
                    }
                }
            }
        }
        if(validarCorreo==3){
            while(true){ 
                System.out.println("Ingrese sus contraseña: ");
                String contraseña = scan.nextLine();
                if(contraseña.equals("GHI_789")){
                    System.out.println("Ingrese el dia en el que esta iniciando sesion: ");
                    int dia = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese el mes: ");
                    int mes = Integer.parseInt(scan.nextLine());
                    System.out.println("Ingrese el año: ");
                    int año = Integer.parseInt(scan.nextLine());
                    if(dia>=8 && mes == 3 && año ==2021 || dia >=1 && mes == 4 && año == 2021 || dia<=2 && mes == 5 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia>=3 && mes == 5 && año==2021 || dia>=1 && mes == 6 && año == 2021 || dia<=11 && mes == 7 && año == 2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia>=12 && dia<=25 && mes==7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia==26 && mes==7 && año==2021){
                        menuAdmin(sistema, correo);
                        break;
                    }
                    else{
                        System.out.println("Disfrute sus vacaciones.");
                        break;
                    }
                    
                }else{
                    System.out.println("Contraseña incorrecta, ¿desea intentarlo nuevamente o cerrar el programa?");
                    System.out.println("Ingrese '1' si desea intentarlo otra vez o ingrese '2' si desea cerrar el programa: ");
                    int opcion = Integer.parseInt(scan.nextLine());
                    if(opcion == 2){
                        break;
                    }
                }
            }
        }
    
    }

    /**
     * The semester start student menu starts.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     * @param correo It is the mail with which the session started.
     */
    public static void menuAlumnoInicio(SistemaUCR sistema, String correo){
        Scanner scan = new Scanner(System.in);
        sistema.inscripcionAsignatura(correo);
        System.out.println("Ingrese el codigo de la asignatura en la que desea inscribirse: ");
        int codigo = Integer.parseInt(scan.nextLine());
        sistema.inscripcionAsignatura2(codigo);
    }

    /**
     * The mid-semester student menu starts.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     * @param correo It is the mail with which the session started.
     */
    public static void menuAlumnoMitad(SistemaUCR sistema, String correo){

    }

    /**
     * The semester start teacher menu starts.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     * @param correo It is the mail with which the session started.
     */
    public static void menuProfesorInicio(SistemaUCR sistema, String correo){
        Scanner scan = new Scanner(System.in);
        sistema.chequeoAlumno(correo);
        System.out.println("Ingrese el paralelo que desea saber de sus alumnos inscritos: ");
        int paralelo = Integer.parseInt(scan.nextLine());
        sistema.chequeoAlumno2(correo, paralelo);

    }

    /**
     * End of semester teacher menu starts.
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     * @param correo It is the mail with which the session started.
     */
    public static void menuProfesorFinal(SistemaUCR sistema, String correo){
        Scanner scan = new Scanner(System.in);
        sistema.notaFinal(correo);
        System.out.println("Ingrese el codigo de la asignatura que desea poner nota final: ");
        int codigo = Integer.parseInt(scan.nextLine());
        sistema.notaFinal2(correo, codigo);
        System.out.println("Ingrese el rut del alumno al que le desea poner la nota final: ");
        String rut = scan.nextLine();
        sistema.notaFinal3(rut, codigo);
    }

    /**
     * The ADMIN menu starts
     * @param sistema The sistema parameter is created to call SistemaUCRImpl.
     * @param correo It is the mail with which the session started.
     */
    public static void menuAdmin(SistemaUCR sistema, String correo){

    }

}

