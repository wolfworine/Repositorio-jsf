package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Cargo;
import pe.edu.cibertec.proyemp.service.CargoService;

@ManagedBean
@RequestScoped
public class CargoManagedBean {
	
	private List<Cargo> cargos = new ArrayList<Cargo>();
	
	private Cargo selecCargo = new Cargo();
	
	@ManagedProperty(value = "#{cargoService}")
	private CargoService cargoService;
	
	@PostConstruct
	public void init(){
		cargos = Lists.newArrayList(
				cargoService.getCargoRepository().findAll());
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
	
	
	


}
