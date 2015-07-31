package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Usuario;
import pe.edu.cibertec.proyemp.service.UsuarioService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class UsuarioManagedBean {

	private List<Usuario> usuarios= new ArrayList<Usuario>();
	
	private List<Usuario> filteredUsuarios= new ArrayList<Usuario>();
	
	private Usuario selecUsuario= new Usuario();

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init(){
		usuarios = Lists.newArrayList(
				usuarioService.getUsuarioRepository().findAll());
	}

	public List<Usuario> getUsuarios() {
		usuarios = Lists.newArrayList(
				usuarioService.getUsuarioRepository().findAll());
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getSelecUsuario() {
		return selecUsuario;
	}

	public void setSelecUsuario(Usuario selecUsuario) {
		this.selecUsuario = selecUsuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> getFilteredUsuarios() {
		return filteredUsuarios;
	}

	public void setFilteredUsuarios(List<Usuario> filteredUsuarios) {
		this.filteredUsuarios = filteredUsuarios;
	}
	
	
	
	
}
