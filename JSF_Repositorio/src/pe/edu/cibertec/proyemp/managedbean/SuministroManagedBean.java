package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Suministro;
import pe.edu.cibertec.proyemp.service.SuministroService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class SuministroManagedBean {

	private List<Suministro> suministros= new ArrayList<Suministro>();
	
	private Suministro selecSuministro= new Suministro();

	@ManagedProperty(value = "#{suministroService}")
	private SuministroService suministroService;
	
	@PostConstruct
	public void init(){
		suministros = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
	}

	public List<Suministro> getSuministros() {
		suministros = Lists.newArrayList(
				suministroService.getSuministroRepository().findAll());
		return suministros;
	}

	public void setSuministros(List<Suministro> suministros) {
		this.suministros = suministros;
	}

	public Suministro getSelecSuministro() {
		return selecSuministro;
	}

	public void setSelecSuministro(Suministro selecSuministro) {
		this.selecSuministro = selecSuministro;
	}

	public SuministroService getSuministroService() {
		return suministroService;
	}

	public void setSuministroService(SuministroService suministroService) {
		this.suministroService = suministroService;
	}

	
	
}
