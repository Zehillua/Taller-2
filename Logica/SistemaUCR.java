package Logica;
import Dominio.*;

public interface SistemaUCR {

    /**
     * A student is entered into the system.
     * @param rutA It is the rout of the student that will be entered into the system.
     * @param correoA It is the mail of the student that will be entered into the system.
     * @param nivel It is the level of the student that will be entered into the system.
     * @param contraseñaA It is the password of the student that will be entered into the system.
     * @param creditos It is the credits of the student that will be entered into the system.
     * @param cantA It is the number of subjects taken of the student that will be entered into the system.
     * @param cantAI It is the number of subjects enrolled of the student that will be entered into the system.
     */
    public void IngresarAlumno(String rutA, String correoA, int nivel, String contraseñaA, int creditos, int cantA, int cantAI);

    /**
     * A subject taken by the student is entered into the system
     * @param codigo It is the code of the subject taken by the student.
     * @param notaFinal It is the final grade of the course taken by the student.
     * @param rut It is to verify to which student the code data and final grade belong.
     */
    public void IngresarAsignaturEstudiante(int codigo, double notaFinal, String rut);

    /**
     * A subject registered by the student is entered into the system
     * @param codigo It is the code of the enrolled subject by the student.
     * @param paralelo It is the parallel of the enrolled subject
     * @param rut It is to verify to which student belongs the code and parallel data of the enrolled subject.
     */
    public void IngresarAsignaturaIEstudiante(int codigo, int paralelo, String rut);

    /**
     * A teacher is entered into the system.
     * @param rutP It's the teacher's rout.
     * @param correoP It's the teacher's mail.
     * @param contraseñaP It's the teacher's password.
     * @param salario It's the teacher's salary.
     */
    public void IngresarProfesor(String rutP, String correoP, String contraseñaP, int salario);

    /**
     * A parallel is entered into the system.
     * @param paralelo Is the number of the parallel.
     * @param codigo It is the code of the subject of that parallel.
     * @param rutP It is the teacher's routine that dictates that parallel.
     */
    public void IngresarParalelo(int paralelo, int codigo, String rutP);

    /**
     * A compulsory subject is entered into the system.
     * @param codigo It is the code of the compulsory subject.
     * @param nombre It is the name of the compulsory subject.
     * @param creditos Are the credits of the compulsory subject.
     * @param tipo It is the type of the compulsory subject.
     * @param nivelMalla It is the mesh level of the compulsory subject.
     * @param cantAsPre Is the number of subjects as a prerequisite.
     */
    public void IngresarAsignaturaOb(int codigo, String nombre, int creditos, String tipo, int nivelMalla, int cantAsPre);

    /**
     * The codes of the prerequisite subjects for the compulsory subject are read.
     * @param nombre It is the name of the prerequisite subject.
     * @param codigoPre Is the code of the prerequisite subject.
     */
    public void agregarCodigosAsOb(String nombre, int codigoPre);

    /**
     * A optional subject is entered into the system.
     * @param codigo It is the code of the optional subject.
     * @param nombre It is the name of the optional subject.
     * @param creditos are the credits of the optional subject.
     * @param tipo It is the code of the optional subject.
     * @param creditosPre are the prerequisite credits that the student must have at least.
     */
    public void IngresarAsignaturaOp(int codigo, String nombre, int creditos, String tipo, int creditosPre);

    /**
     * A graduate student is entered into the system.
     * @param rutE It is the rout of the graduate student.
     */
    public void IngresarAlumnoE(String rutE);

    /**
     * The number of subjects registered by the student is read.
     * @param rut It is the student's routine to associate it with the number of subjects enrolled.
     * @param cantAI It is the number of enrolled subjects.
     */
    public void cantAsignaturaInscrita(String rut, int cantAI);

    /**
     * Confirm the mail.
     * @param correo confirm mail student to login.
     * @return to an a option.
     */
    public int confirmarCorreo2(String correo);

    /**
     * Confirm the mail from student.
     * @param correo Confirm if the email entered is from a student.
     * @return return to boolean.
     */
    public boolean confirmarCorreoA(String correo);

    /**
     * Confirm the mail from teacher.
     * @param correo Confirm if the email entered is from a teacher.
     * @return return to boolean
     */
    public boolean confirmarCorreoP(String correo);

    /**
     * Confirm the password of the one who is logging in.
     * @param correo is the mail of the student or teacher trying to login.
     * @param contraseña is to confirm that the password matches the password for the mail of the student or teacher trying to enter the system.
     * @return to a boolean
     */
    public boolean confirmarContraseña(String correo, String contraseña);

    /**
     * The subjects that you can enroll are displayed.
     * @param correo It is the email of the one who logged in.
     * @return to a String
     */
    public String inscripcionAsignatura(String correo);

    /**
     * The parallels of the subject are displayed and the student will enroll in one..
     * @param codigo It is the code of the subject to which the student wants to enroll.
     */
    public void inscripcionAsignatura2(int codigo);

    /**
     * The student will delete a subject.
     * @param correo It is the email of the one who logged in.
     */
    public void eliminarAsignatura(String correo);

    /**
     * The parallels dictated by the teacher are displayed.
     * @param correo It is the email of the one who logged in.
     */
    public void chequeoAlumno(String correo);

    /**
     * The students enrolled in the parallel selected by the teacher are obtained.
     * @param correo It is the email of the one who logged in.
     * @param paralelo It is the parallel selected by the teacher.
     */
    public void chequeoAlumno2(String correo, int paralelo);

    /**
     *  You get the subjects dictated by the teacher.
     * @param correo It is the email of the one who logged in.
     */
    public void notaFinal(String correo);

    /**
     * The teacher gives the final grade to the selected student.
     * @param correo It is the email of the one who logged in.
     * @param codigo It is the code of the selected subject.
     */
    public void notaFinal2(String correo, int codigo);

    /**
     * The teacher gives the final grade to the selected student.
     * @param rut It is the routine of the selected student.
     * @param codigo It is the code of the selected subject
     */
    public void notaFinal3(String rut, int codigo);

    /**
     * Students files are overwritten.
     * @return to a string
     */
    public String sobreescrituraAlumnos();

    /**
     * Teachers files are overwritten.
     * @return to a string
     */
    public String sobreescrituraProfesores();

    /**
     * Parallels files are overwritten.
     * @return to a string
     */
    public String sobreescrituraParalelos();

    /**
     * Subjects files are overwritten.
     * @return to a string
     */
    public String sobreescrituraAsignaturas();

    /**
     * A file of graduated students is created.
     * @return to a string
     */
    public String archivoEgresados();
}
