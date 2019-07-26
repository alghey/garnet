package mx.com.garnet.services.paciente;

import mx.com.garnet.common.dueno.dto.CrearDuenoRequest;
import mx.com.garnet.common.dueno.dto.CrearDuenoResponse;

public interface DuenoService {
    CrearDuenoResponse crearDueno(CrearDuenoRequest request);
}
