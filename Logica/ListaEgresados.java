package Logica;
import Dominio.*;

public class ListaEgresados {
    
    private int cant;
    private int max;
    private AlumnoE [] listaE;


    public ListaEgresados(int max) {
        this.max = max;
        cant = 0;
        listaE = new AlumnoE[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addAlumnoE(AlumnoE ae){
        if(cant<max){
            listaE[cant] = ae;
            cant++;
            return true;
        }
        return false;
    }

    public AlumnoE getAlumnoEI(int i){
        if(i>=0 && i<=cant){
            return listaE[i];
        }
        return null;
    }


}
