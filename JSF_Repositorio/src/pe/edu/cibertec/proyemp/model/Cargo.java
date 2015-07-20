package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cargo")
public class Cargo {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="nombre", nullable=false, length=200)
	private String nombre;
	
	public Cargo() {
		super();
	}

	public Cargo(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
