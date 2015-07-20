package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,unique=true)
	private Long id;

	@Column(name="nombre", nullable=false, length=200)
	private String nombre;

	@Column(name="descripcion", nullable=false, length=200)
	private String descripcion;
	
	@Column(name="tipo", nullable=false, length=200)
	private String  tipo; 
	
	@Column(name="regla_negocio", nullable=false, length=200)
	private String regla_negocio;
	
	@Column(name="ambito", nullable=false, length=200)
	private String ambito;
	
	@Column(name="propietario_rol", nullable=false, length=200)
	private String  propietario_rol;
	
	@Column(name="propietario_persona", nullable=false, length=200)
	private String propietario_persona;
	
	@Column(name="ubicacion", nullable=false, length=200)
	private String ubicacion;
	
	@Column(name="area", nullable=false, length=200)
	private String area;
	
	@Column(name="cargo", nullable=false, length=200)
	private String cargo;

	
	public Rol() {
		super();
	}

	public Rol(Long id, String nombre, String descripcion, String tipo,
			String regla_negocio, String ambito, String propietario_rol,
			String propietario_persona, String ubicacion, String area,
			String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.regla_negocio = regla_negocio;
		this.ambito = ambito;
		this.propietario_rol = propietario_rol;
		this.propietario_persona = propietario_persona;
		this.ubicacion = ubicacion;
		this.area = area;
		this.cargo = cargo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRegla_negocio() {
		return regla_negocio;
	}

	public void setRegla_negocio(String regla_negocio) {
		this.regla_negocio = regla_negocio;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getPropietario_rol() {
		return propietario_rol;
	}

	public void setPropietario_rol(String propietario_rol) {
		this.propietario_rol = propietario_rol;
	}

	public String getPropietario_persona() {
		return propietario_persona;
	}

	public void setPropietario_persona(String propietario_persona) {
		this.propietario_persona = propietario_persona;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", tipo=" + tipo + ", regla_negocio="
				+ regla_negocio + ", ambito=" + ambito + ", propietario_rol="
				+ propietario_rol + ", propietario_persona="
				+ propietario_persona + ", ubicacion=" + ubicacion + ", area="
				+ area + ", cargo=" + cargo + "]";
	}
	
	
	
}
