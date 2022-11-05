package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoMateria {

    public void save(Materia m);

    public List<Materia> all();

    public Materia porNombre(String nombre);
}
