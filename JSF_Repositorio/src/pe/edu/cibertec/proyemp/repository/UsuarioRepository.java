package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Long>{

}
