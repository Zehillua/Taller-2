package Logica;
import Dominio.*;
public class ListaAsignaturasE {
    
    private int cant;
    private int max;
    private AsignaturaEstudiante [] listaAE;


    public ListaAsignaturasE(int max) {
        this.max = max;
        cant = 0;
        listaAE = new AsignaturaEstudiante[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addAsignaturaE(AsignaturaEstudiante aE){
        if(cant < max){
            listaAE[cant] = aE;
            cant++;
            return true;
        }
        return false;
    }


    public AsignaturaEstudiante getAsignaturaEstudianteI(int i){
        if(i>=0 && i<= cant){
            return listaAE[i];
        }
        return null;
    }
    
    public AsignaturaEstudiante buscaAsignaturaEstudiante(int codigo){
        for(int i =0;i<cant;i++){
            AsignaturaEstudiante aE = listaAE[i];
            int codigo2 = aE.getCodigo();
            if(codigo2 == codigo){
                return aE;
            }
        }
        return null;
    }

    public boolean eliminarAsignaturaE(int codigo){
        int i;
        for(i=0;i<cant;i++){
            if(listaAE[i].getCodigo() == codigo){
                break;
            }
        }
        if(i == cant){
            return false;
        }else{
            for(int j=i;j<cant-1;j++){
                listaAE[j] = listaAE[j+1];
            }
            cant--;
            return true;
        }

    }
}
