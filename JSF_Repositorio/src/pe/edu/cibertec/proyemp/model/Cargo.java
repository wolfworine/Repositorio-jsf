package pe.edu.cibertec.proyemp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cargo")
public class Cargo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="codigo",nullable=false,length=50)
	private String codigo;
	
	@Column(name="nombre", nullable=true, length=200)
	private String nombre;
	
	public Cargo() {
		super();
	}


	public Cargo(String codigo, String nombre) {
		super();
	
		this.codigo = codigo;
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cargo [codigo=" + codigo + ", nombre=" + nombre + "]";
	}




	


}
