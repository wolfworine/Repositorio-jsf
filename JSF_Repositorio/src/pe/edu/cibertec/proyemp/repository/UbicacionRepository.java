package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Area;
import pe.edu.cibertec.proyemp.model.Ubicacion;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long>{

	public final static String FIND_BY_CODIGO= "SELECT u " + 
            "FROM Ubicacion u " +
            "WHERE u.codigo = :codigo ";
	
	@Query(FIND_BY_CODIGO)
	Ubicacion findCod(@Param("codigo")  String codigo);

	
	
}
