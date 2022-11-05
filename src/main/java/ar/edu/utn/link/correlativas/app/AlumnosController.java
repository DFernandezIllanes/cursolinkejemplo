package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Alumno;
import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    @Autowired
    RepoAlumno repo;

    @GetMapping(path = {"/", ""})
    public Page<Alumno> alumnos(Pageable page) {
        return repo.page(page);
    }

    @GetMapping("/{pepe}")
    public Alumno alumno(@PathVariable("pepe") String nombre){
        return repo.porNombre(nombre);
    }

    @PostMapping("/")
    public String alta(@RequestBody @Valid Alumno alumno,
                       BindingResult bindingResult) throws AlumnoRepetidoException{ //El bindingResult indica como salio el proceso de enlace entre el body y materia
        if(bindingResult.hasErrors()){
            return "not ok";
        } else {
            repo.save(alumno);
            return "ok";
        }
    }
}
