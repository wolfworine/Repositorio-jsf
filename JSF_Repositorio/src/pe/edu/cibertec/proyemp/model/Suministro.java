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
@Table(name = "suministro")
public class Suministro {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
		
	@Column(name="id_rol",nullable=false)
	private Long id_rol;	
	
	@Column(name="nombre", nullable=false, length=200)
	private String nombre;
	
	@Column(name="prioridad", nullable=false, length=200)
	private String prioridad;
	
	
	//bi-directional many-to-one association to SuministroAtributo
	@OneToMany(mappedBy="suministro",
			cascade = CascadeType.PERSIST)
	private List<Suministro_Atributo> suministros_Atributos = new ArrayList<Suministro_Atributo>();
	

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

	public List<Suministro_Atributo> getSuministros_Atributos() {
		return suministros_Atributos;
	}

	public void setSuministros_Atributos(
			List<Suministro_Atributo> suministros_Atributos) {
		this.suministros_Atributos = suministros_Atributos;
	}
	
	
	
}
