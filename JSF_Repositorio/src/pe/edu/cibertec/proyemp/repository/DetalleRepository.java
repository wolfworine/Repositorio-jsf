package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Detalle;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, Long>{

	public final static String FIND_BY_CODIGO= "SELECT d " + 
            "FROM Detalle d " +
            "WHERE d.parametro = :parametro ";
	
	@Query(FIND_BY_CODIGO)
	public List<Detalle> findParametro(@Param("parametro") String parametro);


}
