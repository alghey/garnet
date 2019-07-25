package mx.com.garnet.services.paciente.controller;

import mx.com.garnet.common.pacientes.dto.ListaPacientesRequest;
import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;
import mx.com.garnet.common.pacientes.dto.PacienteResponse;
import mx.com.garnet.common.pacientes.vo.PacienteVo;
import mx.com.garnet.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/listarTodos")
    public ListaPacientesResponse listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @PostMapping("/listarPaciente")
    public PacienteResponse listarPaciente(@RequestBody int id){
        return pacienteService.listarPaciente(id);
    }

    @PostMapping("/modificarPaciente")
    public PacienteResponse modificarPaciente(@RequestBody PacienteVo paciente){
        return pacienteService.modificarPaciente(paciente);
    }
}
