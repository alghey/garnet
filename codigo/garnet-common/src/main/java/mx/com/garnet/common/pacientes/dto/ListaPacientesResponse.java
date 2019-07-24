package mx.com.garnet.common.pacientes.dto;

import mx.com.garnet.common.pacientes.vo.PacienteVo;
import mx.com.garnet.common.response.GeneralResponse;

import java.util.List;

public class ListaPacientesResponse extends GeneralResponse {

    private List<PacienteVo> pacientes;

    public List<PacienteVo> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteVo> pacientes) {
        this.pacientes = pacientes;
    }
}
