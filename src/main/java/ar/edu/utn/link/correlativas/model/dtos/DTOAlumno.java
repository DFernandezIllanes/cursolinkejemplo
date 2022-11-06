package ar.edu.utn.link.correlativas.model.dtos;

import ar.edu.utn.link.correlativas.model.Alumno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/*Los DTOs deben estar en el mismo paquete o en un subpaquete de los model(paquete de las entidades) para poder cambiar la
* proyección a través del querystring*/
@Projection(name = "alumno1", types = {Alumno.class})
public interface DTOAlumno {

    /*https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/expressions.html en este link están
     * todas las expresiones que se pueden usar dentro del @Value*/
    @Value("#{target.nombre} #{target.apellido}") //target indica lo que quiero proyectar
    String getNombreCompleto();

    @Value("#{target.materiasAprobadas.size()}")
    int getCantMateriasAprobadas();

}
