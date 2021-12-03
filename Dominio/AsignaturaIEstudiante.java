package Dominio;

public class AsignaturaIEstudiante {
    
    private int codigo;
    private int paralelo;
    
    public AsignaturaIEstudiante(int codigo, int paralelo) {
        this.codigo = codigo;
        this.paralelo = paralelo;
    }


    public int getCodigo() {
        return codigo;
    }

    public int getParalelo() {
        return paralelo;
    }
}
