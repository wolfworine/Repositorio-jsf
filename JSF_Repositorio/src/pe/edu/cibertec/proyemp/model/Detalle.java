package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle")
public class Detalle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="atributo_codigo",nullable=false)
	private String atributo_codigo;
	
	@Column(name="atributo_nombre",nullable=false)
	private String atributo_nombre;
	
	@Column(name="parametro",nullable=false)
	private String parametro;

	public Detalle() {
		super();
	}

	
	public Detalle(Long id, String atributo_codigo, String atributo_nombre,
			String parametro) {
		super();
		this.id = id;
		this.atributo_codigo = atributo_codigo;
		this.atributo_nombre = atributo_nombre;
		this.parametro = parametro;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtributo_codigo() {
		return atributo_codigo;
	}

	public void setAtributo_codigo(String atributo_codigo) {
		this.atributo_codigo = atributo_codigo;
	}

	public String getAtributo_nombre() {
		return atributo_nombre;
	}

	public void setAtributo_nombre(String atributo_nombre) {
		this.atributo_nombre = atributo_nombre;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", atributo_codigo=" + atributo_codigo
				+ ", atributo_nombre=" + atributo_nombre + ", parametro="
				+ parametro + "]";
	}


	
	
	
}
