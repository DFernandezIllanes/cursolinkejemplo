package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "alumnos")
public interface RepoAlumnoJPA extends JpaRepository<Alumno, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Alumno id);

    Alumno findByNombre(String nombre);

    Alumno findAlumnoByApellido(String apellido);

    Page<Alumno> findAlumnoByNombre(String nombre, Pageable page);

    Alumno findAlumnoByNombreAndApellido(String nombre, String apellido);
}
