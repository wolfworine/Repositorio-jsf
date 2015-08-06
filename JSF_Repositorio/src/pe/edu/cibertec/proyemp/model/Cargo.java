package pe.edu.cibertec.proyemp.model;

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
public class Cargo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="codigo",nullable=false,length=50)
	private String codigo;
	
	@Column(name="nombre", nullable=false, length=200)
	private String nombre;
	
	@OneToMany(mappedBy="cargo",
	cascade = CascadeType.PERSIST)
	List<Rol> roles = new ArrayList<Rol>();
	
	public Cargo() {
		super();
	}


	
	public Cargo(Long id, String codigo, String nombre) {
		super();
		this.id = id;
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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "Cargo [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre
				+ "]";
	}


	


}
