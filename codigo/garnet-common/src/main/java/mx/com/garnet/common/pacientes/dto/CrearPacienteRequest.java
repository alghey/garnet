package mx.com.garnet.common.pacientes.dto;

import mx.com.garnet.common.pacientes.vo.PacienteVo;

public class  CrearPacienteRequest {
    private PacienteVo pacienteVo;

    public PacienteVo getPacienteVo() {
        return pacienteVo;
    }

    public void setPacienteVo(PacienteVo pacienteVo) {
        this.pacienteVo = pacienteVo;
    }
}
