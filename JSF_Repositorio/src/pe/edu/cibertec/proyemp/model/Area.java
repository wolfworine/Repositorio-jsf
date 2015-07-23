package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="codigo", nullable=false, length=20)
	private String codigo;
	
	@Column(name="area", nullable=false, length=200)
	private String area;

	public Area() {
		super();
	}
	

	public Area(Long id, String codigo, String area) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.area = area;
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

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "Area [id=" + id + ", codigo=" + codigo + ", area=" + area + "]";
	}

	
}
