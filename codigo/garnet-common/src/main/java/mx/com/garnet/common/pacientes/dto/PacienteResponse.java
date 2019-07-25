package mx.com.garnet.common.pacientes.dto;

import mx.com.garnet.common.pacientes.vo.PacienteVo;
import mx.com.garnet.common.response.GeneralResponse;

import java.util.List;

public class PacienteResponse extends GeneralResponse {
    private PacienteVo paciente;

    public PacienteVo getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteVo paciente) {
        this.paciente = paciente;
    }
}
