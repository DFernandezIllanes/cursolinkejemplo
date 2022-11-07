package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
