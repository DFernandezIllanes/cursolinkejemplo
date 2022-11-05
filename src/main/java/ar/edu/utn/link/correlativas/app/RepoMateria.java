package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoMateria {

    public void save(Materia m) throws MateriaRepetidaException;

    public List<Materia> all();

    public Page<Materia> page(Pageable pageable);

    boolean existeMateriaDeNombre(String nombre);

    public Materia porNombre(String nombre);

    List<Materia> porAnio(Integer anio);
}
