package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestController //indica que hará algo que complementará al RestController
public class MateriasControllerComplement {

    @Autowired
    RepoMateriaJPA repoMateriaJPA;

    @Transactional
    @DeleteMapping("/materias/{materiaId}")
    public @ResponseBody ResponseEntity<Object> delete(@PathVariable("materiaId") Long materiaId){
        Optional<Materia> materiaOptional = repoMateriaJPA.findById(materiaId);

        if(materiaOptional.isPresent()){
            Materia materia = materiaOptional.get();
            if(materia.isActivo()){
                materia.setActivo(false);
                return ResponseEntity.ok("materia borrada ok");
            }
        }
        //return ResponseEntity.notFound().build(); //"la materia no existe";
        return new ResponseEntity<Object>("la materia no existe", HttpStatus.NOT_FOUND);
    }

    @Transactional
    @PostMapping("/materias/{materiaId}/correlativas")
    public @ResponseBody ResponseEntity<Object> agregarCorrelativa(
            @PathVariable("materiaId") Long materiaId,
            @RequestBody Long corrId) throws Exception{

        // Validar input y obtener objetos (Capa Datos) ---------------------------------------
        Optional<Materia> materiaOptional = repoMateriaJPA.findById(materiaId);
        Optional<Materia> materiaCorrOptional = repoMateriaJPA.findById(corrId);

        if(!materiaOptional.isPresent() || !materiaCorrOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Materia materia = materiaOptional.get();
        Materia correlativa = materiaCorrOptional.get();

        //--------------------- Dominio ------------------------------------

        materia.agregarCorrelativa(correlativa);

        //---------------------- Rta al usuario -----------------------------------

        return ResponseEntity.ok(materia);
    }
}
