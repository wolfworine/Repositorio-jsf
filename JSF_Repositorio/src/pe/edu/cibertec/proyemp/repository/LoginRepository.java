package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long>{

	
	@Query(value="select l from login l "
			+ " where l.email like %:email% and l.password = :password")
	Login getValidarUsuarioyPassword( 
			@Param("email") String email,
			@Param("password") String password);




}
