package mx.com.garnet.services.paciente.controller;

<<<<<<< HEAD
import mx.com.garnet.common.pacientes.dto.*;
import mx.com.garnet.common.pacientes.vo.PacienteVo;
=======
import mx.com.garnet.common.pacientes.dto.CrearPacienteRequest;
import mx.com.garnet.common.pacientes.dto.CrearPacienteResponse;
import mx.com.garnet.common.pacientes.dto.ListaPacientesRequest;
import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;
>>>>>>> master
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
    public PacienteResponse listarPaciente(@RequestBody PacienteVo paciente){
        return pacienteService.listarPaciente(paciente);
    }

    @PostMapping("/modificarPaciente")
    public PacienteResponse modificarPaciente(@RequestBody PacienteVo paciente){
        return pacienteService.modificarPaciente(paciente);
    }

    @PostMapping("/crear")
    public CrearPacienteResponse crearPaciente(@RequestBody CrearPacienteRequest request){
        return pacienteService.crearPaciente(request);
    }
}
