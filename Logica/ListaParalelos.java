package Logica;
import Dominio.*;

public class ListaParalelos {
 
    private int cant;
    private int max;
    private Paralelo [] listaPar;


    public ListaParalelos(int max) {
        this.max = max;
        cant = 0;
        listaPar = new Paralelo[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addParalelo(Paralelo par){
        if(cant<max){
            listaPar[cant]=par;
            cant++;
            return true;
        }
        return false;
    }

    public Paralelo getParaleloI(int i){
        if(i>=0 && i<=cant){
            return listaPar[i];
        }
        return null;
    }

    
}
