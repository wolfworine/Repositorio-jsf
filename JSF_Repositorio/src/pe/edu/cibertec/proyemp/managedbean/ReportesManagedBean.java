package pe.edu.cibertec.proyemp.managedbean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.queries.StoredProcedureCall;
import org.eclipse.persistence.sessions.Session;

import pe.edu.cibertec.proyemp.model.Aplicacion;
import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.model.Atributo;
import pe.edu.cibertec.proyemp.model.Detalle;
import pe.edu.cibertec.proyemp.model.Reporte;
import pe.edu.cibertec.proyemp.model.Rol;
import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.model.Ubicacion;
import pe.edu.cibertec.proyemp.service.AplicacionService;
import pe.edu.cibertec.proyemp.service.AreaService;
import pe.edu.cibertec.proyemp.service.AtributoService;
import pe.edu.cibertec.proyemp.service.CargoService;
import pe.edu.cibertec.proyemp.service.DetalleService;
import pe.edu.cibertec.proyemp.service.RolService;
import pe.edu.cibertec.proyemp.service.SuministroService;
import pe.edu.cibertec.proyemp.service.UbicacionService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class ReportesManagedBean {

	private List<Detalle> detalles = new ArrayList<Detalle>();
	private List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();

	private List<Aplicacion> aplicaciones2 = new ArrayList<Aplicacion>();
	
	private List<Rol> roles2 = new ArrayList<Rol>();
	private List<Suministro> rol_suministros = new ArrayList<Suministro>();
	
	private List<Atributo> aroles=new ArrayList<Atributo>();
	
	private List<Atributo> agrupos=new ArrayList<Atributo>();
	
	private List<Atributo> ainbox=new ArrayList<Atributo>();
	
	private List<Atributo> adefaultinbox=new ArrayList<Atributo>();
	
	private List<String> cargos = new ArrayList<String>();
	private List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
	private List<Area> areas = new ArrayList<Area>();

	private List<Reporte> reportes = new ArrayList<Reporte>();
	
	private Aplicacion aplicacion = new Aplicacion();
	private Area area = new Area();
	
	@ManagedProperty(value = "#{detalleService}")
	private DetalleService detalleService;
	
	@ManagedProperty(value = "#{aplicacionService}")
	private AplicacionService aplicacionService;

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
	
	
	private EntityManagerFactory EMF;
	private EntityManager em;
	
	@PostConstruct
	public void init(){
		aplicaciones =  Lists.newArrayList( aplicacionService.getAplicacionRepository().findAll());
		areas=Lists.newArrayList( areaService.getAreaRepository().findAll());
	}

	
	public String reporte() {
		
		
		EMF=Persistence.createEntityManagerFactory("SpringData");
		em=EMF.createEntityManager();
		
		
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("studentById");
/*		JpaEntityManager jpaEntityManager = JpaHelper.getEntityManager(em);
		Session session = jpaEntityManager.getActiveSession();
		StoredProcedureCall call  = new StoredProcedureCall();
		call .setProcedureName("buscarArea");
		call .addNamedArgument();
		call .addNamedArgument();
		call .addNamedOutputArgument("y");
		call .addNamedOutputArgument("z");

		cstmt.setInt("employeeId", 123);
		cstmt.setInt("companyId", 456);
		ResultSet rs = cstmt.executeQuery();*/
		
	    storedProcedure.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
	    
	    storedProcedure.registerStoredProcedureParameter("sname", String.class, ParameterMode.OUT);
	    
	    storedProcedure.registerStoredProcedureParameter("dept", String.class, ParameterMode.OUT);
	    
/*	    storedProcedure.setParameter("id", id);*/

		
		System.out.println("id aplicacion: " + aplicacion.getAplicacion());
		System.out.println("id area: " + 		area.getArea());
		aplicacion.getCodigo();
		area.getCodigo();
		area.getArea();
		
		/*SELECT Distinct cargo FROM repositorio_roles_jsf.rol r where area="ARQUITECTURA EMPRESARIAL";*/

/*		roles2=rolService.getRolRepository().findRol2(area.getArea());

		cargos=rolService.getRolRepository().findCargo(area.getArea()):*/
		reportes=aplicacionService.getAplicacionRepository().BuscarArea(aplicacion.getCodigo(),area.getArea());
		
		
/*		System.out.println(roles2);
		System.out.println(cargos);*/
		
		
		
/*		aplicaciones=aplicacionService.getAplicacionRepository().findAtributo(idrol);*/
	
		
	
		return "/paginas/reportes/vista.xhtml?faces-redirect=true";

		// TODO Auto-generated method stub

	}

	
	public int buscarCargo(List<String> listado,String item) {
		
		if (listado.size()>0) {
			for (int j = 0; j < listado.size(); j++) {
				if (	listado.get(j).equals(item)) {
					return 1;
				}
			
			}
		
		}
		
		return 0;
	}
	
	public List<Detalle> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}


	public List<Aplicacion> getAplicaciones() {
		aplicaciones =  Lists.newArrayList( aplicacionService.getAplicacionRepository().findAll());
		return aplicaciones;
	}


	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}


	public List<Rol> getRoles2() {
		return roles2;
	}


	public void setRoles2(List<Rol> roles2) {
		this.roles2 = roles2;
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


	public List<String> getCargos() {
		return cargos;
	}


	public void setCargos(List<String> cargos) {
		this.cargos = cargos;
	}


	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}


	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}


	public List<Area> getAreas() {
		areas=Lists.newArrayList( areaService.getAreaRepository().findAll());
		return areas;
	}


	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}


	public DetalleService getDetalleService() {
		return detalleService;
	}


	public void setDetalleService(DetalleService detalleService) {
		this.detalleService = detalleService;
	}


	public AplicacionService getAplicacionService() {
		return aplicacionService;
	}


	public void setAplicacionService(AplicacionService aplicacionService) {
		this.aplicacionService = aplicacionService;
	}


	public RolService getRolService() {
		return rolService;
	}


	public void setRolService(RolService rolService) {
		this.rolService = rolService;
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


	public Aplicacion getAplicacion() {
		return aplicacion;
	}


	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public List<Reporte> getReportes() {
		return reportes;
	}


	public void setRseportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}


	public List<Aplicacion> getAplicaciones2() {
		return aplicaciones2;
	}


	public void setAplicaciones2(List<Aplicacion> aplicaciones2) {
		this.aplicaciones2 = aplicaciones2;
	}


	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}
	
	
}
