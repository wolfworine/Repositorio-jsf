package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.service.RolService;
import pe.edu.cibertec.proyemp.service.SuministroService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class SuministroManagedBean {

	private List<Suministro> suministros= new ArrayList<Suministro>();
	
	private List<Rol> roles = new ArrayList<Rol>();
	
	private List<Suministro> filteredSuministros= new ArrayList<Suministro>();

	private Suministro selectSuministro= new Suministro();
	


	private Suministro suministro=new Suministro();
	
	@ManagedProperty(value = "#{suministroService}")
	private SuministroService suministroService;
	
	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;
	
	@PostConstruct
	public void init(){
		suministros  = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
	}

	
	public String  nuevo() {
		return "/paginas/suministro/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		
		return "/paginas/suministro/modificar.xhtml?faces-redirect=true";
	}
	
	public String  volver() {
		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  registrar() {
		suministroService.getSuministroRepository().save(suministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + suministro.getNombre() + " ingresado"
				));
		suministro = new Suministro();

		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  modificar() {
		suministroService.getSuministroRepository().save(selectSuministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selectSuministro.getNombre() + " actualizado"
				));
		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  veratributo() {
		return "/paginas/suministro_atributo/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public List<Suministro> getSuministros() {
		suministros = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
		return suministros;
	}

	public void setSuministros(List<Suministro> suministros) {
		this.suministros = suministros;
	}

	public List<Rol> getRoles() {
		roles = Lists.newArrayList(
				rolService.getRolRepository().findAll());
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	


	public Suministro getSelectSuministro() {
		return selectSuministro;
	}


	public void setSelectSuministro(Suministro selectSuministro) {
		this.selectSuministro = selectSuministro;
	}


	public SuministroService getSuministroService() {
		return suministroService;
	}

	public void setSuministroService(SuministroService suministroService) {
		this.suministroService = suministroService;
	}

	public List<Suministro> getFilteredSuministros() {
		return filteredSuministros;
	}

	public void setFilteredSuministros(List<Suministro> filteredSuministros) {
		this.filteredSuministros = filteredSuministros;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}


	public Suministro getSuministro() {
		return suministro;
	}


	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}





	
	
}
