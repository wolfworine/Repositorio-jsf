package pe.edu.cibertec.proyemp.managedbean;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.service.AreaService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class AreaManagedBean{
	


	private List<Area> areas = new ArrayList<Area>();
	
	private List<Area> filteredAreas = new ArrayList<Area>();
	
	private Area selecArea = new Area();
	
	private Area busqueda = new Area();
	
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



	
	
	
	
}
