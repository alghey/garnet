package mx.com.garnet.persistence.repository;

import mx.com.garnet.persistence.entities.DatDueno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepository extends CrudRepository<DatDueno, Integer > {
}
