package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Cargo;
import pe.edu.cibertec.proyemp.service.CargoService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class CargoManagedBean {
	
	private List<Cargo> cargos = new ArrayList<Cargo>();
	
	private List<Cargo> filteredCargos = new ArrayList<Cargo>();
	
	private Cargo selecCargo = new Cargo();
	
	private Cargo busqueda = new Cargo();
	
	@ManagedProperty(value = "#{cargoService}")
	private CargoService cargoService;
	
	@PostConstruct
	public void init(){
		cargos = Lists.newArrayList(
				cargoService.getCargoRepository().findAll());
		System.out.println(cargos);
	}

	public List<Cargo> getCargos() {
		cargos = Lists.newArrayList(
				cargoService.getCargoRepository().findAll());
		
		
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo getSelecCargo() {
		return selecCargo;
	}

	public void setSelecCargo(Cargo selecCargo) {
		this.selecCargo = selecCargo;
	}

	public CargoService getCargoService() {
		return cargoService;
	}

	public void setCargoService(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public List<Cargo> getFilteredCargos() {
		return filteredCargos;
	}

	public void setFilteredCargos(List<Cargo> filteredCargos) {
		this.filteredCargos = filteredCargos;
	}

	public Cargo getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Cargo busqueda) {
		this.busqueda = busqueda;
	}


	
	


}
