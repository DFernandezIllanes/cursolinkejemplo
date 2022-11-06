package ar.edu.utn.link.correlativas.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
public class Materia {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nombre;

	@Min(1)
	private Integer anio;

	@Transient
	private Collection<Materia> correlativas;
	
	public Materia(){}

	public Materia(String nombre, Integer anio) {
		super();
		this.nombre = nombre;
		this.anio = anio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<Materia> getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(Collection<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	@Override
	public String toString() {
		return "Materia{" +
				"nombre='" + nombre + '\'' +
				", correlativas=" + correlativas +
				'}';
	}
}
