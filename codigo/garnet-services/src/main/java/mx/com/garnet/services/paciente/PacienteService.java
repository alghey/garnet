package mx.com.garnet.services.paciente;


import mx.com.garnet.common.pacientes.dto.*;
import mx.com.garnet.common.pacientes.vo.PacienteVo;

public interface PacienteService {
    ListaPacientesResponse listarPacientes();
    PacienteResponse listarPaciente(PacienteVo paciente);
    PacienteResponse modificarPaciente(PacienteVo paciente);
    CrearPacienteResponse crearPaciente(CrearPacienteRequest request);
}
