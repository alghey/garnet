package mx.com.garnet.persistence.repository;

import mx.com.garnet.persistence.entities.DatPaciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<DatPaciente, Integer> {
}
