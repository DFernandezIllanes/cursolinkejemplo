package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController //Con esto sabe Spring que tiene que levantar MateriasController
@RequestMapping("/materias")
public class MateriasController {

    @Autowired
    RepoMateria repo;

    @GetMapping(path = {"/", ""})
    public Page<Materia> materias(Pageable page,
                                  @RequestParam(value = "anio", required = false) Integer anio) {
        if(anio != null){
            return new PageImpl<Materia>(repo.porAnio(anio));
        } else {
            return repo.page(page);
        }
    }

    @GetMapping("/{pepe}")
    public Materia materia(@PathVariable("pepe") String nombre){
        return repo.porNombre(nombre);
    }

    @PostMapping("/")
    public String alta(@RequestBody @Valid Materia materia,
                       BindingResult bindingResult) throws MateriaRepetidaException{ //El bindingResult indica como salio el proceso de enlace entre el body y materia
        if(bindingResult.hasErrors()){
            return "not ok";
        } else {
            repo.save(materia);
            return "ok";
        }
    }
}
