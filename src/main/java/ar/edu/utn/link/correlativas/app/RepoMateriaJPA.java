package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "materias") //http://localhost:8080/materias/search
public interface RepoMateriaJPA extends JpaRepository<Materia, Long> {

    @Override
    @RestResource(exported = false) //Para indicar que no muestre el método
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Materia id);

    Page<Materia> findByAnio(Integer anio, Pageable page);
    Materia findByNombre(String nombre);
}
