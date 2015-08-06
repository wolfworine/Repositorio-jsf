package pe.edu.cibertec.proyemp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ubicacion" , referencedColumnName="codigo")
	private Ubicacion ubicacion= new Ubicacion();
	
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="area" , referencedColumnName="area")
	private Area area= new Area();
	
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="cargo" , referencedColumnName="nombre")
	private Cargo cargo= new Cargo();
	
	//bi-directional many-to-one association to SuministroAtributo
	@OneToMany(mappedBy="rol",
			cascade = CascadeType.PERSIST)
	private List<Suministro_Atributo> suministros_Atributos = new ArrayList<Suministro_Atributo>();
	
	public Rol() {
		super();
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

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	



	
	
}
