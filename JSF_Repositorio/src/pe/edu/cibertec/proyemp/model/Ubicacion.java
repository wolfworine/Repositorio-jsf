package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="codigo",nullable=false,length=50)
	private String codigo;
	
	@Column(name="ubicacion", nullable=false, length=200)
	private String ubicacion;

	public Ubicacion() {
		super();
	}

	public Ubicacion(Long id, String codigo, String ubicacion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Ubicacion [id=" + id + ", codigo=" + codigo + ", ubicacion="
				+ ubicacion + "]";
	}



	
	
	

}