package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepoMateriaMemoria implements RepoMateria{

    private List<Materia> materias;

    public RepoMateriaMemoria(){
        super();
        materias = new ArrayList<>();
    }

    @Override
    public void save(Materia m) {
        materias.add(m);
    }

    @Override
    public List<Materia> all(){
        return this.materias;
    }

    @Override
    public Page<Materia> page(Pageable pageable) {
        int desde = pageable.getPageNumber() * pageable.getPageSize();
        List<Materia> subList2 = this.materias.subList(desde, desde + pageable.getPageSize());
        return new PageImpl<Materia>(subList2, pageable, this.materias.size());
    }

    @Override
    public Materia porNombre(String nombre) {
        return this.materias.stream().filter(materia -> materia.getNombre().equals(nombre)).findFirst().get();
    }

    @Override
    public List<Materia> porAnio(Integer anio) {
        return this.materias.stream().filter(materia -> materia.getAnio().equals(anio)).collect(Collectors.toList());
    }
}
