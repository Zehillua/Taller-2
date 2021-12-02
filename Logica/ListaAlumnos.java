package Logica;
import Dominio.*;

public class ListaAlumnos {
    
    private int cant;
    private int max;
    private Alumno [] listaAl;

    public ListaAlumnos(int max) {
        this.max = max;
        cant = 0;
        listaAl = new Alumno[max];
    }

    public boolean addAlumno(Alumno a){
        if(cant<max){
            listaAl[cant] = a;
            cant++;
            return true;
        }
        return false;
    }

    public int getCant(){
        return cant;
    }

    public Alumno getAlumnoI(int i){
        if(i>=0 && i<=cant){
            return listaAl[i];
        }
        return null;
    }

    public Alumno buscarAlumnoR(String rut){
        for(int i=0;i<cant;i++){
            Alumno a = listaAl[i];
            String rut2 = a.getRutA();
            String correo2 = a.getCorreoA();
            if(rut2.equals(rut)){
                return a;
            }
        }
        return null;
    }

    public Alumno buscarAlumnoC(String correo){
        for(int i=0;i<cant;i++){
            Alumno a = listaAl[i];
            String correo2 = a.getCorreoA();
            if(correo2.equals(correo)){
                return a;
            }
        }
        return null;
    }

    public boolean eliminarAlumno(String rut){
        int i;
        for( i=0;i<cant;i++){
            if(listaAl[i].getRutA().equals(rut)){
                break;
            }
        }
        if(i==cant){
            return false;
        }else{
            for(int j = i;j<cant-1;j++){
                listaAl[j] = listaAl[j+1];
            }
            cant--;
            return true;
        }
    }
}
