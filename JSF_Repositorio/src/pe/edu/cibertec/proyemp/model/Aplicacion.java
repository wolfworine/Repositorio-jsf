package pe.edu.cibertec.proyemp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


/**
 * The persistent class for the aplicacion database table.
 * 
 */

@NamedStoredProcedureQuery(name = "Aplication.buscarArea", procedureName = "buscarArea", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "app", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "are1", type = Integer.class) })
@Entity
@Table(name = "aplicacion")

public class Aplicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="codigo", nullable=false, length=20)
	private String codigo;

	@Column(name="aplicacion", nullable=false, length=200)
	private String aplicacion;

	
	public Aplicacion() {
		super();
	}



	public Aplicacion(Long id, String codigo, String aplicacion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.aplicacion = aplicacion;
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



	public String getAplicacion() {
		return aplicacion;
	}



	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}



	@Override
	public String toString() {
		return "Aplicacion [id=" + id + ", codigo=" + codigo + ", aplicacion="
				+ aplicacion + "]";
	}




	
	

}
