package Logica;
import Dominio.*;

public interface SistemaUCR {

    public void IngresarAlumno(String rutA, String correoA, int nivel, String contraseñaA, int creditos, int cantA, int cantAI);

    public void IngresarAsignaturEstudiante(int codigo, double notaFinal, String rut);

    public void IngresarAsignaturaIEstudiante(int codigo, int paralelo, String rut);

    public void IngresarProfesor(String rutP, String correoP, String contraseñaP, int salario);

    public void IngresarParalelo(int paralelo, int codigo, String rutP);

    public void IngresarAsignaturaOb(int codigo, String nombre, int creditos, String tipo, int nivelMalla, int cantAsPre,
    int codigoPre);

    public void IngresarAsignaturaOp(int codigo, String nombre, int creditos, String tipo, int creditosPre);

    public void IngresarAlumnoE(String rutE);

    public int confirmarCorreo2(String correo);

    public boolean confirmarCorreoA(String correo);

    public boolean confirmarCorreoP(String correo);

    public boolean confirmarContraseña(String correo, String contraseña);

    public void inscripcionAsignatura(String correo);

    public void eliminarAsignatura(String correo);

    public void chequeoAlumno(String correo);

    public void notaFinal(String correo);

    public String sobreescrituraAlumnos();

    public String sobreescrituraProfesores();

    public String sobreescrituraParalelos();

    public String sobreescrituraAsignaturas();

    public String archivoEgresados();
}
