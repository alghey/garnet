package mx.com.garnet.services.paciente;

import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;
import mx.com.garnet.common.pacientes.vo.PacienteVo;

public interface PacienteService {
    ListaPacientesResponse listarPacientes();
    PacienteVo listarpPacientesId(int Id);
}
