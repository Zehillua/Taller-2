package Logica;
import Dominio.*;

public class ListaProfesores {
    
    private int cant;
    private int max;
    private Profesor [] listaPr;


    public ListaProfesores(int max) {
        this.max = max;
        cant = 0;
        listaPr = new Profesor[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addProfesor(Profesor pr){
        if(cant<max){
            listaPr[cant] = pr;
            cant++;
            return true;
        }
        return false;
    }

    public Profesor buscaProfesor(String correo){
        for(int i=0;i<cant;i++){
            Profesor p = listaPr[i];
            String correo2 = p.getCorreoP();
            if(correo2.equals(correo)){
                return p;
            }
        }
        return null;
    }

    public Profesor getProfesorI(int i){
        if(i>=0 && i<=cant){
            return listaPr[i];
        }
        return null;
    }
    
}
