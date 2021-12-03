package Logica;
import Dominio.*;
public class ListaAsignaturasIE {
    
    private int cant;
    private int max;
    private AsignaturaIEstudiante [] listaAI;


    public ListaAsignaturasIE(int max) {
        this.max = max;
        cant = 0;
        listaAI = new AsignaturaIEstudiante[max];
    }


    public int getCant(){
        return cant;
    }

    public boolean addAsignaturaE(AsignaturaIEstudiante aIE){
        if(cant < max){
            listaAI[cant] = aIE;
            cant++;
            return true;
        }
        return false;
    }


    public AsignaturaIEstudiante getAsignaturaIEstudianteI(int i){
        if(i>=0 && i<= cant){
            return listaAI[i];
        }
        return null;
    }
    
    public AsignaturaIEstudiante buscaAsignaturaIEstudiante(int codigo){
        for(int i =0;i<cant;i++){
            AsignaturaIEstudiante aIE = listaAI[i];
            int codigo2 = aIE.getCodigo();
            if(codigo2 == codigo){
                return aIE;
            }
        }
        return null;
    }

    public AsignaturaIEstudiante buscaAsignaturaIEstudianteP(int paralelo){
        for(int i =0;i<cant;i++){
            AsignaturaIEstudiante aIE = listaAI[i];
            int paralelo2 = aIE.getParalelo();
            if(paralelo2 == paralelo){
                return aIE;
            }
        }
        return null;
    }

    public boolean eliminarAsignaturaIE(int codigo){
        int i;
        for(i=0;i<cant;i++){
            if(listaAI[i].getCodigo() == codigo){
                break;
            }
        }
        if(i == cant){
            return false;
        }else{
            for(int j=i;j<cant-1;j++){
                listaAI[j] = listaAI[j+1];
            }
            cant--;
            return true;
        }

    }
    
}
