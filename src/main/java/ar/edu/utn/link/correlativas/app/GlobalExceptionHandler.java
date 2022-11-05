package ar.edu.utn.link.correlativas.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice //Se activa cuando se produce un error
public class GlobalExceptionHandler {

    @ExceptionHandler(MateriaRepetidaException.class) //Este método se ejecutará cuando salte una excepcion de tipo MateriaRepetidaExcepcion
    @ResponseBody //El resultado ponelo en el body
    @ResponseStatus(HttpStatus.CONFLICT) //Para que tambien retorne este status
    String materiaRepetida(MateriaRepetidaException ex){
        return "La materia " + ex.getNombreMateria() + " ya existe";
    }
}
