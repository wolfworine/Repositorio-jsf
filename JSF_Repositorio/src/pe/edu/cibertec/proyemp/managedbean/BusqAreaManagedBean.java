package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.service.AreaService;

@ManagedBean
@RequestScoped
public class BusqAreaManagedBean {
	
/*	
	private List<Area> filtered = new ArrayList<Area>();
	
	private Area selecArea = new Area();
	
	private Area busqueda = new Area();
		
	
	@ManagedProperty(value = "#{areaService}")
	private AreaService areaService;

	public String buscar() {
		filtered =		areaService.getAreaRepository().
				findByCodigoOrArea(busqueda.getCodigo(), busqueda.getArea());
		
		System.out.println(filtered);
		return null;
	}

	public List<Area> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Area> filtered) {
		this.filtered = filtered;
	}

	public Area getSelecArea() {
		return selecArea;
	}

	public void setSelecArea(Area selecArea) {
		this.selecArea = selecArea;
	}

	public Area getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Area busqueda) {
		this.busqueda = busqueda;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	
	public String  nuevo() {
		return "/paginas/area/editar.xhtml?faces-redirect=true";
	}
	
	public String  editar() {
		return "/paginas/area/modificar.xhtml?faces-redirect=true";
	}
	
	
	public String  modificar() {
		
		areaService.getAreaRepository().save(selecArea);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Registro " + selecArea.getArea()+ " Actualizado"
				));
		return "/paginas/area/mantenimiento.xhtml?faces-redirect=true";
	}
	*/
	

	


}
