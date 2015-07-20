package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "suministro")
public class Suministro {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,unique=true)
	private Long id;
		
	@Column(name="id_rol",nullable=false)
	private Long id_rol;	
	
	@Column(name="nombre", nullable=false, length=200)
	private String nombre;
	
	@Column(name="prioridad", nullable=false, length=200)
	private String prioridad;
	
	public Suministro() {
		super();
	}

	public Suministro(Long id, Long id_rol, String nombre, String prioridad) {
		super();
		this.id = id;
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.prioridad = prioridad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Suministro [id=" + id + ", id_rol=" + id_rol + ", nombre="
				+ nombre + ", prioridad=" + prioridad + "]";
	}
	
	
	
}
