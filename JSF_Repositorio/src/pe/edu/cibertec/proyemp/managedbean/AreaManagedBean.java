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
import pe.edu.cibertec.proyemp.service.AreaService;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class AreaManagedBean{
	
	private List<Area> areas = new ArrayList<Area>();
	
	private List<Area> filteredAreas = new ArrayList<Area>();
	
	private Area selecArea = new Area();
	
	private Area busqueda = new Area();
	
	private Area area = new Area();
	
	@ManagedProperty(value = "#{areaService}")
	private AreaService areaService;

	
	@PostConstruct
	public void init(){
		areas =  Lists.newArrayList( areaService.getAreaRepository().findAll());
	}
	
	
	public List<Area> getAreas() {
		areas = Lists.newArrayList(
				areaService.getAreaRepository().findAll());
		return areas;
	}

	
	public String  nuevo() {
		return "/paginas/area/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		return "/paginas/area/modificar.xhtml?faces-redirect=true";
	}
	
	public String  volver() {
		return "/paginas/area/mantenimiento.xhtml?faces-redirect=true";
	}
	
	public String  registrar() {
		areaService.getAreaRepository().save(area);
		area = new Area();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + area.getArea() + " ingresado"
				));
		return null;
	}
	
	
	public String  modificar() {
		areaService.getAreaRepository().save(selecArea);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + area.getArea() + " Actualizado"
				));
		return "/paginas/area/mantenimiento.xhtml?faces-redirect=true";
	}
	

	
/*	public String buscar() {
		filteredAreas =		areaService.getAreaRepository().
				findByCodigoOrArea(busqueda.getCodigo(), busqueda.getArea());
		return null;
	}*/
	
	
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}


	public Area getSelecArea() {
		return selecArea;
	}


	public void setSelecArea(Area selecArea) {
		this.selecArea = selecArea;
	}


	public List<Area> getFilteredAreas() {
		return filteredAreas;
	}


	public void setFilteredAreas(List<Area> filteredAreas) {
		this.filteredAreas = filteredAreas;
	}
	
	

	public Area getBusqueda() {
		return busqueda;
	}


	public void setBusqueda(Area busqueda) {
		this.busqueda = busqueda;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}

	
	
}
