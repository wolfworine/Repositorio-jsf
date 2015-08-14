package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pe.edu.cibertec.proyemp.model.Aplicacion;
import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.model.Cargo;
import pe.edu.cibertec.proyemp.model.Ubicacion;

@ManagedBean
@SessionScoped
public class ReportesManagedBean {

	
	private List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
	private List<Cargo> cargos = new ArrayList<Cargo>();
	private List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
	private List<Area> areas = new ArrayList<Area>();
}
