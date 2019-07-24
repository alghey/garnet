package mx.com.garnet.persistence.repository;

import mx.com.garnet.persistence.entities.DatConsulta;
import mx.com.garnet.persistence.entities.DatMedico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends CrudRepository<DatConsulta, Integer> {
    List<DatConsulta> findAllByDatMedico(DatMedico medico);

}
