package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long>{

    public final static String FIND_BY_EMAIL_PASSWORD= "SELECT p " + 
            "FROM Login p " +
            "WHERE p.email = :email "+
            "and p.password = :password";
    
	@Query(FIND_BY_EMAIL_PASSWORD)
	public List<Login> findbyEmailandPassword( 
			@Param("email") String email,
			@Param("password") String password);




}
