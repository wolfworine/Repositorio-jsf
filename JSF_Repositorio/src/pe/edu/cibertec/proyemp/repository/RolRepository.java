package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long>{

	
	@Query("select r from Rol r " +
			"Where r.area=:area")
	List<Rol> findRol(@Param("area")String area);

/*	@Query(value = "select r from Rol r " +
			"Where r.area=:area and r.id in "+
			"( select disctinct max(a.id_rol) from Atributo a where a.aplicacion=:aplicacion and r.id=a.id_rol) "+
			"order by r.id desc", nativeQuery = true)
	List<Rol> findRol2(@Param("area")String area,@Param("aplicacion")String aplicacion);*/

	@Query("select r from Rol r " +
			"Where r.area=:area order by r.cargo desc")
	List<Rol> findRol2(@Param("area")String area);

	
	@Query("select distinct r.cargo from Rol r " +
			"Where r.area=:area order by r.cargo asc")
	List<String> findCargo(@Param("area")String area);

	


}
