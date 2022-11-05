package ar.edu.utn.link.correlativas;

import java.util.Collection;

public class Materia {
	
	private String nombre;

	private Integer anio;
	private Collection<Materia> correlativas;
	
	
	public Materia(String nombre, Integer anio) {
		super();
		this.nombre = nombre;
		this.anio = anio;
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
