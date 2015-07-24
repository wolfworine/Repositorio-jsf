package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Ubicacion;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long>{

	
	
}
