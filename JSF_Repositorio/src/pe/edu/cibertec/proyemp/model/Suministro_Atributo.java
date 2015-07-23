package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "suministro_atributo")
public class Suministro_Atributo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
		
	@Column(name="id_rol",nullable=false)
	private Long id_rol;	
	
	@Column(name="id_suministro",nullable=false)
	private Long id_suministro;
	
	@Column(name="parametro", nullable=false, length=200)
	private String parametro;
	
	@Column(name="atributo_codigo", nullable=false, length=200)
	private String atributo_codigo;
	
	@Column(name="atributo_nombre", nullable=false, length=200)
	private String atributo_nombre;
	
	@Column(name="aplicaccion", nullable=false, length=200)
	private String aplicacion;
	
	public Suministro_Atributo() {
		super();
	}

	public Suministro_Atributo(Long id, Long id_rol, Long id_suministro,
			String parametro, String atributo_codigo, String atributo_nombre,
			String aplicacion) {
		super();
		this.id = id;
		this.id_rol = id_rol;
		this.id_suministro = id_suministro;
		this.parametro = parametro;
		this.atributo_codigo = atributo_codigo;
		this.atributo_nombre = atributo_nombre;
		this.aplicacion = aplicacion;
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

	public Long getId_suministro() {
		return id_suministro;
	}

	public void setId_suministro(Long id_suministro) {
		this.id_suministro = id_suministro;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
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

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public String toString() {
		return "Suministro_Atributo [id=" + id + ", id_rol=" + id_rol
				+ ", id_suministro=" + id_suministro + ", parametro="
				+ parametro + ", atributo_codigo=" + atributo_codigo
				+ ", atributo_nombre=" + atributo_nombre + ", aplicacion="
				+ aplicacion + "]";
	}
	

}
