package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestController
public class AlumnosControllerComplement {

    @Autowired
    RepoAlumnoJPA repoAlumnoJPA;
    @Autowired
    RepoMateriaJPA repoMateriaJPA;

    @Transactional
    @DeleteMapping("/alumnos/{alumnoId}")
    public @ResponseBody ResponseEntity<Object> delete(@PathVariable("alumnoId") Long alumnoId){
        Optional<Alumno> alumnoOptional = repoAlumnoJPA.findById(alumnoId);

        if(alumnoOptional.isPresent()){
            Alumno alumno = alumnoOptional.get();
            if(alumno.isActivo()){
                alumno.setActivo(false);
                return ResponseEntity.ok("alumno dado de baja ok");
            }
        }
        //return ResponseEntity.notFound().build(); //"la materia no existe";
        return new ResponseEntity<Object>("el alumno no existe", HttpStatus.NOT_FOUND);
    }

    @Transactional
    @PostMapping("/alumnos/{alumnoId}/aprobadas")
    public @ResponseBody ResponseEntity<Object> agregarMateriaAprobada(
            @PathVariable("alumnoId") Long alumnoId,
            @RequestBody Long materiaId) throws Exception{

        // Validar input y obtener objetos (Capa Datos) ---------------------------------------
        Optional<Alumno> alumnoOptional = repoAlumnoJPA.findById(alumnoId);
        Optional<Materia> materiaAprobadaOptional = repoMateriaJPA.findById(materiaId);

        if(!alumnoOptional.isPresent() || !materiaAprobadaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumno = alumnoOptional.get();
        Materia materiaAprobada = materiaAprobadaOptional.get();

        //--------------------- Dominio ------------------------------------

        alumno.agregarMateriaAprobada(materiaAprobada);

        //---------------------- Rta al usuario -----------------------------------

        return ResponseEntity.ok(alumno);
    }
}
