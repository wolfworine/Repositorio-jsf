package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "suministro_atributo")
public class Suministro_Atributo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
			
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol",referencedColumnName="id")
	private Rol rol=new Rol();

	//bi-directional many-to-one association to Suministro
	@ManyToOne
	@JoinColumn(name="id_suministro",referencedColumnName="id")
	private Suministro suministro=new Suministro();
	
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



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}



	public Suministro getSuministro() {
		return suministro;
	}



	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
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
		return "Suministro_Atributo [id=" + id + ", rol=" + rol
				+ ", suministro=" + suministro + ", parametro=" + parametro
				+ ", atributo_codigo=" + atributo_codigo + ", atributo_nombre="
				+ atributo_nombre + ", aplicacion=" + aplicacion + "]";
	}



}
