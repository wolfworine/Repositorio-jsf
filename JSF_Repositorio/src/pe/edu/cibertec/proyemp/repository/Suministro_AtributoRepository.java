package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Suministro_Atributo;

@Repository
public interface Suministro_AtributoRepository extends CrudRepository<Suministro_Atributo, Long>{

}
