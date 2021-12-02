package Dominio;
public class AsignaturaEstudiante {
    
    private int codigo;
    private double notaFinal;


    public AsignaturaEstudiante(int codigo, double notaFinal) {
        this.codigo = codigo;
        this.notaFinal = notaFinal;
    }


    public int getCodigo() {
        return codigo;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }   
    
}
