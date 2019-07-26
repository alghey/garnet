package mx.com.garnet.services.paciente;

import mx.com.garnet.common.pacientes.dto.CrearPacienteRequest;
import mx.com.garnet.common.pacientes.dto.CrearPacienteResponse;
import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;

public interface PacienteService {
    ListaPacientesResponse listarPacientes();
    CrearPacienteResponse crearPaciente(CrearPacienteRequest request);
}
