package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.proyemp.model.Suministro_Atributo;
import pe.edu.cibertec.proyemp.service.Suministro_AtributoService;

import com.google.common.collect.Lists;

@ManagedBean
@RequestScoped
public class Suministro_AtributoManagedBean {
	
	private List<Suministro_Atributo> suministros_atributos= new ArrayList<Suministro_Atributo>();
	
	private Suministro_Atributo selecSuministro_Atributo= new Suministro_Atributo();

	@ManagedProperty(value = "#{suministro_atributoService}")
	private Suministro_AtributoService suministro_atributoService;
	
	@PostConstruct
	public void init(){
		suministros_atributos = Lists.newArrayList(
				suministro_atributoService.getSuministro_atributoRepository().findAll());
	}

	public List<Suministro_Atributo> getSuministros_atributos() {
		suministros_atributos = Lists.newArrayList(
				suministro_atributoService.getSuministro_atributoRepository().findAll());
		return suministros_atributos;
	}

	public void setSuministros_atributos(
			List<Suministro_Atributo> suministros_atributos) {
		this.suministros_atributos = suministros_atributos;
	}

	public Suministro_Atributo getSelecSuministro_Atributo() {
		return selecSuministro_Atributo;
	}

	public void setSelecSuministro_Atributo(
			Suministro_Atributo selecSuministro_Atributo) {
		this.selecSuministro_Atributo = selecSuministro_Atributo;
	}

	public Suministro_AtributoService getSuministro_atributoService() {
		return suministro_atributoService;
	}

	public void setSuministro_atributoService(
			Suministro_AtributoService suministro_atributoService) {
		this.suministro_atributoService = suministro_atributoService;
	}

	
	
}
