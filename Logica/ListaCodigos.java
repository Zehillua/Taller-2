package Logica;
import Dominio.*;


public class ListaCodigos {
    
    private int cant;
    private int max;
    private CodigoAsignaturas [] lCodigos;


    public ListaCodigos(int max) {
        this.max = max;
        cant = 0;
        lCodigos = new CodigoAsignaturas[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addCodigos(CodigoAsignaturas cA){
        if(cant<max){
            lCodigos[cant] = cA;
            cant++;
            return true;
        }
        return false;
    }

    public CodigoAsignaturas getCodigosI(int i){
        if(i>=0 && i<=cant){
            return lCodigos[i];
        }
        return null;
    }
    
}
