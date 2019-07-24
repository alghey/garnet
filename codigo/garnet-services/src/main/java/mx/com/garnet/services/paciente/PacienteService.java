package mx.com.garnet.services.paciente;

import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;

public interface PacienteService {
    ListaPacientesResponse listarPacientes();
    ListaPacientesResponse listaPaciente(int id);
}
