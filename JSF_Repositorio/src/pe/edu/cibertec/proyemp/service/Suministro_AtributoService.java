package pe.edu.cibertec.proyemp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.proyemp.repository.Suministro_AtributoRepository;


@Component
public class Suministro_AtributoService {

	
	@Autowired
	private Suministro_AtributoRepository suministro_atributoRepository;

	public Suministro_AtributoRepository getSuministro_atributoRepository() {
		return suministro_atributoRepository;
	}

	public void setSuministro_atributoRepository(
			Suministro_AtributoRepository suministro_atributoRepository) {
		this.suministro_atributoRepository = suministro_atributoRepository;
	}
	
	
}
