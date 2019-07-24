package mx.com.garnet.persistence.repository;

import mx.com.garnet.persistence.entities.DatMedico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<DatMedico, Integer> {

}
