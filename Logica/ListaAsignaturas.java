package Logica;
import Dominio.*;

public class ListaAsignaturas {

    private int cant;
    private int max;
    private Asignatura [] listaAs;


    public ListaAsignaturas(int max) {
        this.max = max;
        cant = 0;
        listaAs = new Asignatura[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addAsignatura(Asignatura as){
        if(cant<max){
            listaAs[cant] = as;
            cant++;
            return true;
        }
        return false;
    }

    public Asignatura getAsignaturaI(int i){
        if(i >=0 && i<=cant){
            return listaAs[i];
        }
        return null;
    }
    
    public Asignatura buscarAsignatura(String nombreAs){
        for(int i=0;i<cant;i++){
            Asignatura as = listaAs[i];
            String nombreAs2 = as.getNombre();
            if(nombreAs2.equals(nombreAs)){
                return as;
            }
        }
        return null;
    }
 
    public boolean eliminarAsignatura(String nombre){
        int i;
        for(i=0;i<cant;i++){
            if(listaAs[i].getNombre().equals(nombre)){
                break;
            }
        }
        if(i == cant){
            return false;
        }else{
            for(int j=i;j<cant-1;j++){
                listaAs[j] = listaAs[j+1];
            }
            cant--;
            return true;
        }

    }

}
