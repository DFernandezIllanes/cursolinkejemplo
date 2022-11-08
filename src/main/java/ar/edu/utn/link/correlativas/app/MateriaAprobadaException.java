package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;

public class MateriaAprobadaException extends Exception{

    private Alumno alumno;
    private Materia materia;

    public MateriaAprobadaException() {
        super();
    }

    public MateriaAprobadaException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MateriaAprobadaException(String message, Throwable cause){
        super(message, cause);
    }

    public MateriaAprobadaException(String message, Alumno alumno, Materia materia){
        super(message);
        this.alumno = alumno;
        this.materia = materia;
    }

    public MateriaAprobadaException(String message){
        super(message);
    }

    public MateriaAprobadaException(Throwable cause){
        super(cause);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
