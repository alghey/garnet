package mx.com.garnet.common.pacientes.dto;

import mx.com.garnet.common.pacientes.vo.PacienteVo;
import mx.com.garnet.common.response.GeneralResponse;

public class CrearPacienteResponse extends GeneralResponse {
    private PacienteVo pacienteVo;

    public PacienteVo getPacienteVo() {
        return pacienteVo;
    }

    public void setPacienteVo(PacienteVo pacienteVo) {
        this.pacienteVo = pacienteVo;
    }
}
