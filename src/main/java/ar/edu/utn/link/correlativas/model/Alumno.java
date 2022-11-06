package ar.edu.utn.link.correlativas.model;

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

	@Transient
	@JsonIgnore
	private List<Curso> cursos;

	@ManyToMany
	private Collection<Materia>  materiasAprobadas;

	public Alumno(){
		this.materiasAprobadas = new ArrayList<>();
	}
		
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Alumno(String nombre, String apellido) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
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
		return  materiasAprobadas;
	}
	public void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public void inscribir(Curso curso) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
