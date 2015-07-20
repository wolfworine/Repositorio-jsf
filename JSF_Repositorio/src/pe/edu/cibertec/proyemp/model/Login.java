package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="usuario",nullable=false)
	private String usuario;
	
	@Column(name="password",nullable=false)
	private String password;

	
	
	public Login() {
		super();
	}

	public Login(Long id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", usuario=" + usuario + ", password="
				+ password + "]";
	}
	
	
	
	
}
