package pe.edu.cibertec.proyemp.service;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.proyemp.repository.UsuarioRepository;

public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	

}
