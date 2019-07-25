package mx.com.garnet.common.pacientes.dto;

import mx.com.garnet.common.pacientes.vo.PacienteVo;

public class PacienteRequest {
    private PacienteVo paciente;

    public PacienteVo getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteVo paciente) {
        this.paciente = paciente;
    }
}
