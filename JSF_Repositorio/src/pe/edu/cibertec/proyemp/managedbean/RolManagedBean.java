package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.service.RolService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class RolManagedBean {

	private List<Rol> roles = new ArrayList<Rol>();
	
	private List<Rol> filteredRoles = new ArrayList<Rol>();
	
	private Rol selecRol = new Rol();

	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;
	
	@PostConstruct
	public void init(){
		roles = Lists.newArrayList(
				rolService.getRolRepository().findAll());
	}

	public List<Rol> getRoles() {
		roles = Lists.newArrayList(
				rolService.getRolRepository().findAll());
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Rol getSelecRol() {
		return selecRol;
	}

	public void setSelecRol(Rol selecRol) {
		this.selecRol = selecRol;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	public List<Rol> getFilteredRoles() {
		return filteredRoles;
	}

	public void setFilteredRoles(List<Rol> filteredRoles) {
		this.filteredRoles = filteredRoles;
	}
	
	
	
}
