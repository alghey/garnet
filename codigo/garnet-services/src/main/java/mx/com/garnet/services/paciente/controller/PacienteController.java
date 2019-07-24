package mx.com.garnet.services.paciente.controller;

import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;
import mx.com.garnet.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/listarTodos")
    public ListaPacientesResponse listarPacientes(){
        return pacienteService.listarPacientes();
    }
}
