package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.model.Atributo;
import pe.edu.cibertec.proyemp.model.Cargo;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.model.Ubicacion;
import pe.edu.cibertec.proyemp.service.AreaService;
import pe.edu.cibertec.proyemp.service.AtributoService;
import pe.edu.cibertec.proyemp.service.CargoService;
import pe.edu.cibertec.proyemp.service.RolService;
import pe.edu.cibertec.proyemp.service.SuministroService;
import pe.edu.cibertec.proyemp.service.UbicacionService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class RolManagedBean {

	private List<Rol> roles = new ArrayList<Rol>();
	private List<Cargo> cargos = new ArrayList<Cargo>();
	private List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
	private List<Area> areas = new ArrayList<Area>();
	

	//Vista de Suministro
	
	private List<Suministro> rol_suministros = new ArrayList<Suministro>();
	
	//Vista de Suministro_Atributo
	
	private List<Atributo> aroles=new ArrayList<Atributo>();
	
	private List<Atributo> agrupos=new ArrayList<Atributo>();
	
	private List<Atributo> ainbox=new ArrayList<Atributo>();
	
	private List<Atributo> adefaultinbox=new ArrayList<Atributo>();
	

	
	private String codarea;
	
	private String codubicacion;
	
	private String codcargo;
	

	private String codarea2;
	
	private String codubicacion2;
	
	private String codcargo2;

	private Rol rol =new Rol();
	
	private Suministro suministro=new Suministro();
	
	private Atributo atributo=new Atributo();
	
	private Rol selecRol = new Rol();
	
	private Suministro selecSuministro = new Suministro();

	private Atributo selectAtributo = new Atributo();
	
	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;
	
	@ManagedProperty(value = "#{suministroService}")
	private SuministroService suministroService;
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;
	
	@ManagedProperty(value = "#{cargoService}")
	private CargoService cargoService;
	
	@ManagedProperty(value = "#{ubicacionService}")
	private UbicacionService ubicacionService;
	
	@ManagedProperty(value = "#{areaService}")
	private AreaService areaService;
	
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
	
	public String  nuevo() {
		return "/paginas/rol/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		
		
		Area area=areaService.getAreaRepository().findCod2(selecRol.getArea());
		Cargo cargo=cargoService.getCargoRepository().findCod2(selecRol.getCargo());
		codarea2=area.getCodigo();
		codubicacion2=selecRol.getUbicacion();
		codcargo2=cargo.getCodigo();

		return "/paginas/rol/modificar.xhtml?faces-redirect=true";
	}
	
	
	
	public String  volver() {
		return "/paginas/rol/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  registrar() {
	
		
		Area area=areaService.getAreaRepository().findCod(codarea);
		Ubicacion ubicacion=ubicacionService.getUbicacionRepository().findCod(codubicacion);
		Cargo cargo=cargoService.getCargoRepository().findCod(codcargo);
		
	/*	rol.getArea().setId(area.getId());
		rol.getArea().setArea(area.getArea());
		rol.getCargo().setId(cargo.getId());
		rol.getCargo().setNombre(cargo.getNombre());
		rol.getUbicacion().setCodigo(ubicacion.getCodigo());
		rol.getUbicacion().setUbicacion(ubicacion.getUbicacion());*/
		
		rol.setArea(area.getArea());
		rol.setUbicacion(codubicacion);
		rol.setCargo(cargo.getNombre());
		System.out.println(rol);
		rolService.getRolRepository().save(rol);
		rol = new Rol();

		return "/paginas/rol/mantenimiento.xhtml?faces-redirect=true";
	}
	
	
	public String  modificar() {
		Area area=areaService.getAreaRepository().findCod(codarea2);
		Ubicacion ubicacion=ubicacionService.getUbicacionRepository().findCod(codubicacion2);
		Cargo cargo=cargoService.getCargoRepository().findCod(codcargo2);
		
		selecRol.setArea(area.getArea());
		selecRol.setUbicacion(codubicacion2);
		selecRol.setCargo(cargo.getNombre());
		System.out.println(selecRol);

		
		rolService.getRolRepository().save(selecRol);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecRol.getNombre() + " Actualizado"
				));
		return "/paginas/rol/mantenimiento.xhtml?faces-redirect=true";
	}
	
	
	//suministro
	public String  versuministro() {
		System.out.println(selecRol.getId());
		rol_suministros=suministroService.getSuministroRepository().findSuministro(selecRol.getId());

		return "/paginas/rol/mantenimiento_suministro.xhtml?faces-redirect=true";
	}

	public String  nuevo_suministro() {
		return "/paginas/rol/editar_suministro.xhtml?faces-redirect=true";
	}
	
	public String  editar_suministro() {
		
		return "/paginas/rol/modificar_suministro.xhtml?faces-redirect=true";
	}
	
	public String  volver_suministro() {
		return "/paginas/rol/mantenimiento_suministro.xhtml?faces-redirect=true";
	}
	
	public String  registrar_suministro() {
		
		suministroService.getSuministroRepository().save(suministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + suministro.getNombre() + " ingresado"
				));
		suministro = new Suministro();
		return "/paginas/rol/editar_suministro.xhtml?faces-redirect=true";
	}
	
	
	public String  modificar_suministro() {
		suministroService.getSuministroRepository().save(selecSuministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecSuministro.getNombre() + " actualizado"
				));
		return "/paginas/rol/modificar_suministro.xhtml?faces-redirect=true";
	}
	
	
	//suministro_atributo
	public String  veratributo() {

		
			String roles="ROLES";
			String grupos="GRUPOS";
			String inbox="INBOX";
			String defualtinbox="DEFAULTINBOX";
			
			Long id_rol=selecSuministro.getId_rol();
			Long id_suministro=selecSuministro.getId();
			System.out.println("rol "+id_rol );
			System.out.println("suministro "+ id_suministro);
			
			aroles=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,roles);
			agrupos=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,grupos);
		ainbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,inbox);
			adefaultinbox=  atributoService.getAtributoRepository().findParametro(id_rol,id_suministro,defualtinbox);
		return "/paginas/rol/mantenimiento_suministro_atributo.xhtml?faces-redirect=true";
	}

	public String  nuevo_suministro_atributo() {
		return "/paginas/rol/editar_suministro_atributo.xhtml?faces-redirect=true";
	}
	
	public String  editar_suministro_atributo() {
		
		return "/paginas/rol/modificar_suministro_atributo.xhtml?faces-redirect=true";
	}
	
	public String  volver_suministro_atributo() {
		return "/paginas/rol/mantenimiento_suministro_atributo.xhtml?faces-redirect=true";
	}
	
	public String  registrar_suministro_atributo() {
		
		suministroService.getSuministroRepository().save(suministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + suministro.getNombre() + " ingresado"
				));
		suministro = new Suministro();
		return "/paginas/rol/editar_suministro_atributo.xhtml?faces-redirect=true";
	}
	
	
	public String  modificar_suministro_atributo() {
		suministroService.getSuministroRepository().save(selecSuministro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecSuministro.getNombre() + " actualizado"
				));
		return "/paginas/rol/modificar_suministro_atributo.xhtml?faces-redirect=true";
	}
	

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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



	public List<Cargo> getCargos() {
		cargos=Lists.newArrayList(
				cargoService.getCargoRepository().findAll());
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public List<Ubicacion> getUbicaciones() {
		ubicaciones=Lists.newArrayList(
				ubicacionService.getUbicacionRepository().findAll());
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<Area> getAreas() {
		areas=Lists.newArrayList(
				areaService.getAreaRepository().findAll());
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public UbicacionService getUbicacionService() {
		return ubicacionService;
	}

	public void setUbicacionService(UbicacionService ubicacionService) {
		this.ubicacionService = ubicacionService;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public String getCodarea() {
		return codarea;
	}

	public void setCodarea(String codarea) {
		this.codarea = codarea;
	}

	public String getCodubicacion() {
		return codubicacion;
	}

	public void setCodubicacion(String codubicacion) {
		this.codubicacion = codubicacion;
	}

	public String getCodcargo() {
		return codcargo;
	}

	public void setCodcargo(String codcargo) {
		this.codcargo = codcargo;
	}

	public String getCodarea2() {
		return codarea2;
	}

	public void setCodarea2(String codarea2) {
		this.codarea2 = codarea2;
	}

	public String getCodubicacion2() {
		return codubicacion2;
	}

	public void setCodubicacion2(String codubicacion2) {
		this.codubicacion2 = codubicacion2;
	}

	public String getCodcargo2() {
		return codcargo2;
	}

	public void setCodcargo2(String codcargo2) {
		this.codcargo2 = codcargo2;
	}

	public List<Suministro> getRol_suministros() {
		return rol_suministros;
	}

	public void setRol_suministros(List<Suministro> rol_suministros) {
		this.rol_suministros = rol_suministros;
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

	public Suministro getSuministro() {
		return suministro;
	}

	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public Suministro getSelecSuministro() {
		return selecSuministro;
	}

	public void setSelecSuministro(Suministro selecSuministro) {
		this.selecSuministro = selecSuministro;
	}

	public Atributo getSelectAtributo() {
		return selectAtributo;
	}

	public void setSelectAtributo(Atributo selectAtributo) {
		this.selectAtributo = selectAtributo;
	}

	public SuministroService getSuministroService() {
		return suministroService;
	}

	public void setSuministroService(SuministroService suministroService) {
		this.suministroService = suministroService;
	}

	public AtributoService getAtributoService() {
		return atributoService;
	}

	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}


	
}
