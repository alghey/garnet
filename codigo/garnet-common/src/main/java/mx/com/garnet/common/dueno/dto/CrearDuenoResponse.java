package mx.com.garnet.common.dueno.dto;

import mx.com.garnet.common.pacientes.vo.DuenoVo;
import mx.com.garnet.common.response.GeneralResponse;

public class CrearDuenoResponse extends GeneralResponse {
    private DuenoVo duenoVo;

    public DuenoVo getDuenoVo() {
        return duenoVo;
    }

    public void setDuenoVo(DuenoVo duenoVo) {
        this.duenoVo = duenoVo;
    }
}
