package ar.edu.utn.link.correlativas.model.dtos;

import ar.edu.utn.link.correlativas.model.Alumno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "alumno3", types = {Alumno.class})
public interface DTOAlumno3 {

    @Value("#{target.nombre.toUpperCase()}-#{target.apellido.toUpperCase()}")
    String getNombreCompleto();
}
