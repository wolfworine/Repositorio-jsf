package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Suministro;

@Repository
public interface SuministroRepository extends CrudRepository<Suministro, Long>{

}
