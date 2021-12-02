package Logica;
import Dominio.*;
import java.util.*;
import java.io.*;

public class App {

    public static void main(String args [])throws IOException {
        SistemaUCR sistema = new SistemaUCRImpl();
        //LecturaEstudiantes(sistema);
        //LecturaAsignaturas(sistema);
        //LecturaParalelos(sistema);
        LecturaProfesores(sistema);
        inicioSesion(sistema);
    }
    


    public static void LecturaEstudiantes(SistemaUCR sistema)throws IOException{
        File file = new File("C://Users//ignac//Desktop//a//UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 2//Código//estudiantes.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String linea = scan.nextLine();
            String [] partes = linea.split(",");
            for(int i=0;i<4;i++){
                String rut = partes[0];
                String correo = partes[1];
                int nivel = Integer.parseInt(partes[2]);
                String contraseña = partes[3];
                int creditos = 0;
                File file2 = new File("C://Users//ignac//Desktop//a//UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 2//Código//estudiantes.txt");
                Scanner scan2 = new Scanner(file2);
                while(scan2.hasNextLine()){
                    String linea2 = scan2.nextLine();
                    String [] partes2 = linea2.split(",");
                    
                }
            }
            
            
            
        }
    }


    public static void LecturaProfesores(SistemaUCR sistema)throws IOException{
        File file = new File("C://Users//ignac//Desktop//a//UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 2//Código//profesores.txt");
        Scanner scan = new Scanner(file);
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
    }

    public static void LecturaParalelos(SistemaUCR sistema)throws IOException{
        File file = new File("C://Users//ignac//Desktop//a//UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 2//Código//paralelos.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String linea = scan.nextLine();
            String [] partes = linea.split(",");
            int paralelo = Integer.parseInt(partes[0]);
            int codigo = Integer.parseInt(partes[1]);
            String rutP = partes[2];
            sistema.IngresarParalelo(paralelo, codigo, rutP);
        }
    }

    public static void LecturaAsignaturas(SistemaUCR sistema)throws IOException{
        File file = new File("C://Users//ignac//Desktop//a//UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 2//Código//asignaturas.txt");
        Scanner scan = new Scanner(file);
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
                for(int i=6;i<partes.length;i++){
                    int codigoPre = Integer.parseInt(partes[i]);
                    System.out.println(codigo+nombre+creditos+tipo+nivelMalla+cantAsPre+codigoPre);
                    sistema.IngresarAsignaturaOb(codigo, nombre, creditos, tipo, nivelMalla, cantAsPre, codigoPre);
                }
            }else{
                int creditosPre = Integer.parseInt(partes[4]);
                sistema.IngresarAsignaturaOp(codigo, nombre, creditos, tipo, creditosPre);
            }
        }
    }

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
                    if(dia>=8 && dia<=2 && mes>=3 && mes<=5 && año==2021){
                        //menuAlumnoInicio(sistema);
                        break;
                    }
                    if(dia>=3 && dia<=11 && mes>=5 && mes<=7 && año==2021){
                        //menuAlumnoMitad(sistema);
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
                    if(dia>=8 && dia<=2 && mes>=3 && mes<=5 && año==2021){
                        //menuProfesorInicio(sistema);
                        break;
                    }
                    if(dia>=3 && dia<=11 && mes>=5 && mes<=7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia>=12 && dia<=25 && mes==7 && año==2021){
                        //menuProfesorFinal(sistema);
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
                    if(dia>=8 && dia<=2 && mes>=3 && mes<=5 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia>=3 && dia<=11 && mes>=5 && mes<=7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia>=12 && dia<=25 && mes==7 && año==2021){
                        System.out.println("No hay acciones disponibles.");
                        break;
                    }
                    if(dia==26 && mes==7 && año==2021){
                        //menuAdmin(sistema);
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
}

