package ar.edu.utn.link.correlativas.app;

public class AlumnoRepetidoException extends Exception{

    private String nombreAlumno;

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public AlumnoRepetidoException(){

    }
    public AlumnoRepetidoException(String message) {
        super();
        nombreAlumno = message;
    }

    public AlumnoRepetidoException(Throwable cause){
        super(cause);
    }

    public AlumnoRepetidoException(String message, Throwable cause){
        super(message, cause);
    }

    public AlumnoRepetidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
