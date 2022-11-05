package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //Con esto sabe Spring que tiene que levantar MateriasController
@RequestMapping("/materias")
public class MateriasController {

    @Autowired
    RepoMateria repo;

    @GetMapping(path = {"/", ""})
    public List<Materia> materias() {
        return repo.all();
    }

    @GetMapping("/{pepe}")
    public Materia materia(@PathVariable("pepe") String nombre){
        return repo.porNombre(nombre);
    }


}
