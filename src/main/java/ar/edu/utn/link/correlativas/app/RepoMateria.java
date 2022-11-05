package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoMateria {

    public void save(Materia m);
}
