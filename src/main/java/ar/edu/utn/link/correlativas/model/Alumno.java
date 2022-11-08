package ar.edu.utn.link.correlativas.model;

import ar.edu.utn.link.correlativas.app.MateriaAprobadaException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Alumno {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String nombre;

	private String apellido;

	private boolean activo;

	@Transient
	@JsonIgnore
	private List<Curso> cursos;

	@ManyToMany
	private Collection<Materia>  materiasAprobadas;

	public Alumno(){
		this.materiasAprobadas = new ArrayList<>();
		this.activo = true;
	}
		
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
		this.activo = true;
		this.materiasAprobadas = new ArrayList<>();
	}

	public Alumno(String nombre, String apellido) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.activo = true;
		this.materiasAprobadas = new ArrayList<>();
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public Collection<Materia> getMateriasAprobadas() {

		return  new ArrayList<Materia>(this.materiasAprobadas);
	}
	protected void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public void agregarMateriaAprobada(Materia materiaAprobada) throws MateriaAprobadaException{
		if(this.getMateriasAprobadas().contains(materiaAprobada)){
			throw new MateriaAprobadaException("el alumno ya ha aprobado la materia", this, materiaAprobada);
		}

		if(!materiaAprobada.isActivo()){
			throw new MateriaAprobadaException("la materia no es válida", this, materiaAprobada);
		}

		this.materiasAprobadas.add(materiaAprobada);
	}

	public void inscribir(Curso curso) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
