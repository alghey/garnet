package mx.com.garnet.persistence.repository;

import mx.com.garnet.persistence.entities.CatEspecie;
import org.springframework.data.repository.CrudRepository;

public interface EspecieRepository extends CrudRepository<CatEspecie, Integer> {
}
