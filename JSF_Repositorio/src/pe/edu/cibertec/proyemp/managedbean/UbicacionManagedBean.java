package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Ubicacion;
import pe.edu.cibertec.proyemp.service.UbicacionService;

import com.google.common.collect.Lists;


@ManagedBean
@RequestScoped
public class UbicacionManagedBean {
	
	private List<Ubicacion> ubicaciones= new ArrayList<Ubicacion>();
	
	private List<Ubicacion> filteredUbicaciones= new ArrayList<Ubicacion>();
	
	private Ubicacion selecUbicacion= new Ubicacion();

	@ManagedProperty(value = "#{ubicacionService}")
	private UbicacionService ubicacionService;
	
	@PostConstruct
	public void init(){
		ubicaciones = Lists.newArrayList(
				ubicacionService.getUbicacionRepository().findAll());
	}

	public List<Ubicacion> getUbicaciones() {
		ubicaciones = Lists.newArrayList(
				ubicacionService.getUbicacionRepository().findAll());
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Ubicacion getSelecUbicacion() {
		return selecUbicacion;
	}

	public void setSelecUbicacion(Ubicacion selecUbicacion) {
		this.selecUbicacion = selecUbicacion;
	}

	public UbicacionService getUbicacionService() {
		return ubicacionService;
	}

	public void setUbicacionService(UbicacionService ubicacionService) {
		this.ubicacionService = ubicacionService;
	}

	public List<Ubicacion> getFilteredUbicaciones() {
		return filteredUbicaciones;
	}

	public void setFilteredUbicaciones(List<Ubicacion> filteredUbicaciones) {
		this.filteredUbicaciones = filteredUbicaciones;
	}
	
	

}
