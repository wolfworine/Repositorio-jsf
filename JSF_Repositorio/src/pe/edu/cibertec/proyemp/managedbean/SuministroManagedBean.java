package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Aplicacion;
import pe.edu.cibertec.proyemp.model.Atributo;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.service.AplicacionService;
import pe.edu.cibertec.proyemp.service.AtributoService;
import pe.edu.cibertec.proyemp.service.RolService;
import pe.edu.cibertec.proyemp.service.SuministroService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class SuministroManagedBean {

	private List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
	
	private List<Rol> roles = new ArrayList<Rol>();
	
	//Vista de Suministro
	
	private List<Suministro> suministros= new ArrayList<Suministro>();
	private Suministro suministro=new Suministro();
	private Suministro selecSuministro = new Suministro();
	//Vista de Suministro_Atributo
	
	private String rolesa;
	private String gruposa;
	private String inboxa;
	private String defaultinboxa;
	
	private List<Atributo> aroles=new ArrayList<Atributo>();
	
	private List<Atributo> agrupos=new ArrayList<Atributo>();
	
	private List<Atributo> ainbox=new ArrayList<Atributo>();
	
	private List<Atributo> adefaultinbox=new ArrayList<Atributo>();
	private Atributo atributo=new Atributo();
	private Atributo selectAtributo = new Atributo();
	
	@ManagedProperty(value = "#{aplicacionService}")
	private AplicacionService aplicacionService;
	
	@ManagedProperty(value = "#{suministroService}")
	private SuministroService suministroService;
	
	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;
	
	@PostConstruct
	public void init(){
		suministros  = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
	}

	//vista suministro
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
		suministroService.getSuministroRepository().save(selecSuministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecSuministro.getNombre() + " actualizado"
				));
		return "/paginas/suministro/mantenimiento.xhtml?faces-redirect=true";
	}
	
	//vista atributo
	public String  veratributo() {
		rolesa="ROLES";
		gruposa="GRUPOS";
		inboxa="INBOX";
		defaultinboxa="DEFAULTINBOX";
		
		Long id_rol=selecSuministro.getId_rol();
		Long id_suministro=selecSuministro.getId();
		System.out.println("rol "+id_rol );
		System.out.println("suministro "+ id_suministro);
		
		aroles=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,rolesa);
		agrupos=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,gruposa);
		ainbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,inboxa);
		adefaultinbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,defaultinboxa);
		
		
		System.out.println("aroles"+aroles);
		System.out.println("agrupos"+agrupos);
		System.out.println("ainbox"+aroles);
		System.out.println("adefaultinbox"+adefaultinbox);

		return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
	}
	
	// Atributo Roles
	public String  nuevo_atributo_rol() {
		atributo.setId_rol(selecSuministro.getId_rol());
		atributo.setId_suministro(selecSuministro.getId());

		atributo.setParametro(rolesa);
		return "/paginas/atributo/editar.xhtml?faces-redirect=true";
	}

	public String  editar_atributo_rol() {

		return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
	}

	// Atributo Grupos
	public String  nuevo_atributo_grupo() {
		atributo.setId_rol(selecSuministro.getId_rol());
		atributo.setId_suministro(selecSuministro.getId());

		atributo.setParametro(gruposa);
		return "/paginas/atributo/editar.xhtml?faces-redirect=true";
	}

	public String  editar_atributo_grupo() {

		
		return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
	}

	// Atributo Inbox 
	public String  nuevo_atributo_inbox() {
		atributo.setId_rol(selecSuministro.getId_rol());
		atributo.setId_suministro(selecSuministro.getId());

		atributo.setParametro(inboxa);
		return "/paginas/atributo/editar.xhtml?faces-redirect=true";
	}

	public String  editar_atributo_inbox() {

		
		return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
	}

	// Atributo Default Inbox
	public String  nuevo_atributo_defaultinboxa() {
		atributo.setId_rol(selecSuministro.getId_rol());
		atributo.setId_suministro(selecSuministro.getId());

		atributo.setParametro(defaultinboxa);
		return "/paginas/atributo/editar.xhtml?faces-redirect=true";
	}

	public String  editar_atributo_defaultinboxa() {

		System.out.println("atributo" + atributo);
		return "/paginas/atributo/modificar.xhtml?faces-redirect=true";
	}


	public String  volver_atributo() {
		System.out.println("atributo" + selectAtributo);
		return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
	}

	public String  registrar_atributo() {
		
		atributoService.getAtributoRepository().save(atributo);
		Long id_rol=selecSuministro.getId_rol();
		Long id_suministro=selecSuministro.getId();

		aroles=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,rolesa);
		agrupos=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,gruposa);
		ainbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,inboxa);
		adefaultinbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,defaultinboxa);
		atributo =new Atributo();

		return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
	}


	public String  modificar_atributo() {
		atributoService.getAtributoRepository().save(selectAtributo);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selectAtributo.getId() + " actualizado"
				));
		Long id_rol=selecSuministro.getId_rol();
		Long id_suministro=selecSuministro.getId();

		aroles=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,rolesa);
		agrupos=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,gruposa);
		ainbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,inboxa);
		adefaultinbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,defaultinboxa);
		return "/paginas/atributo/mantenimiento.xhtml?faces-redirect=true";
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

	public List<Aplicacion> getAplicaciones() {
		aplicaciones = Lists.newArrayList(
				aplicacionService.getAplicacionRepository().findAll());
		return aplicaciones;
	}

	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public Suministro getSuministro() {
		return suministro;
	}

	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	public Suministro getSelecSuministro() {
		return selecSuministro;
	}

	public void setSelecSuministro(Suministro selecSuministro) {
		this.selecSuministro = selecSuministro;
	}

	public String getRolesa() {
		return rolesa;
	}

	public void setRolesa(String rolesa) {
		this.rolesa = rolesa;
	}

	public String getGruposa() {
		return gruposa;
	}

	public void setGruposa(String gruposa) {
		this.gruposa = gruposa;
	}

	public String getInboxa() {
		return inboxa;
	}

	public void setInboxa(String inboxa) {
		this.inboxa = inboxa;
	}

	public String getDefaultinboxa() {
		return defaultinboxa;
	}

	public void setDefaultinboxa(String defaultinboxa) {
		this.defaultinboxa = defaultinboxa;
	}

	public List<Atributo> getAroles() {
		return aroles;
	}

	public void setAroles(List<Atributo> aroles) {
		this.aroles = aroles;
	}

	public List<Atributo> getAgrupos() {
		return agrupos;
	}

	public void setAgrupos(List<Atributo> agrupos) {
		this.agrupos = agrupos;
	}

	public List<Atributo> getAinbox() {
		return ainbox;
	}

	public void setAinbox(List<Atributo> ainbox) {
		this.ainbox = ainbox;
	}

	public List<Atributo> getAdefaultinbox() {
		return adefaultinbox;
	}

	public void setAdefaultinbox(List<Atributo> adefaultinbox) {
		this.adefaultinbox = adefaultinbox;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public Atributo getSelectAtributo() {
		return selectAtributo;
	}

	public void setSelectAtributo(Atributo selectAtributo) {
		this.selectAtributo = selectAtributo;
	}

	public AplicacionService getAplicacionService() {
		return aplicacionService;
	}

	public void setAplicacionService(AplicacionService aplicacionService) {
		this.aplicacionService = aplicacionService;
	}


	public SuministroService getSuministroService() {
		return suministroService;
	}


	public void setSuministroService(SuministroService suministroService) {
		this.suministroService = suministroService;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	public AtributoService getAtributoService() {
		return atributoService;
	}

	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}
	
}
