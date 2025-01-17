package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //Con esto sabe Spring que tiene que levantar MateriasController
@RequestMapping("/materias_old")
public class MateriasController {

    @Autowired
    RepoMateriaJPA repo;


    /*@GetMapping("/{pepe}")
    public Materia materia(@PathVariable("pepe") String nombre){
        return repo.findByNombre(nombre);
    }*/

    /*@PostMapping("/")
    public String alta(@RequestBody @Valid Materia materia,
                       BindingResult bindingResult) throws MateriaRepetidaException{ //El bindingResult indica como salio el proceso de enlace entre el body y materia
        if(bindingResult.hasErrors()){
            return "not ok";
        } else {
            repo.save(materia);
            return "ok";
        }
    }*/
}
