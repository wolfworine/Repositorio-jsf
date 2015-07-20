package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="area", nullable=false, length=200)
	private String area;

	public Area() {
		super();
	}
	public Area(Long id, String area) {
		super();
		this.id = id;
		this.area = area;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", area=" + area + "]";
	}

	
	
}
