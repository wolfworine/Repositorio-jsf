package pe.edu.cibertec.proyemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Atributo;

@Repository
public interface AtributoRepository extends CrudRepository<Atributo, Long>{

	public final static String FIND_BY_PARAMETRO= "SELECT s " + 
            "FROM Atributo s " +
            "WHERE s.id_rol = :id_rol "+
            "and s.id_suministro = :id_suministro "+
            "and s.parametro = :parametro";
    @Query(FIND_BY_PARAMETRO)
    public List<Atributo> findParametro(@Param("id_rol") Long id_rol,
    		@Param("id_suministro") Long id_suministro,
    		@Param("parametro") String parametro);

}
