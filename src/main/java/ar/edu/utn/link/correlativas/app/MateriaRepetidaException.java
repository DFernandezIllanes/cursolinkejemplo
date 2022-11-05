package ar.edu.utn.link.correlativas.app;

public class MateriaRepetidaException extends Exception {

    private String nombreMateria;

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public MateriaRepetidaException(){

    }
    public MateriaRepetidaException(String message) {
        super();
        nombreMateria = message;
    }

    public MateriaRepetidaException(Throwable cause){
        super(cause);
    }

    public MateriaRepetidaException(String message, Throwable cause){
        super(message, cause);
    }

    public MateriaRepetidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
