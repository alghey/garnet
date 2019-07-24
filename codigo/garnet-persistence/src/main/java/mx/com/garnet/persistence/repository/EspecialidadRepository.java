package mx.com.garnet.persistence.repository;

import mx.com.garnet.persistence.entities.CatEspecialidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends CrudRepository<CatEspecialidad, Integer> {

}
