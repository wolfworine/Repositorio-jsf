package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Area;


@Repository
public interface AreaRepository  extends CrudRepository<Area, Long>{

/*	 public final static String FIND_BY_CODIGO_NOMBRE= "SELECT p " + 
	            "FROM area p " +
	            "WHERE p.codigo = :codigo "+
	            "and p.nombre = :nombre";
	
	@Query(FIND_BY_CODIGO_NOMBRE)
	List<Area> findbyIdandName(
			@Param("codigo") String codigo,
			@Param("nombre") String nombre);*/


	

}
