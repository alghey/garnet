package mx.com.garnet.services.paciente.impl;

import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;
import mx.com.garnet.common.pacientes.vo.DuenoVo;
import mx.com.garnet.common.pacientes.vo.PacienteVo;
import mx.com.garnet.persistence.entities.DatDueno;
import mx.com.garnet.persistence.entities.DatPaciente;
import mx.com.garnet.persistence.repository.PacienteRepository;
import mx.com.garnet.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PacienteService")
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public ListaPacientesResponse listarPacientes() {
        ListaPacientesResponse response = new ListaPacientesResponse();
        List<PacienteVo> pacientes = new ArrayList<>();

        Iterable<DatPaciente> pacientesDB = pacienteRepository.findAll();

        try{
            pacientesDB.forEach(pacienteDB->{
                DatDueno duenoDB = pacienteDB.getDatDueno();
                DuenoVo duenoVo = new DuenoVo(){{
                    setIdDueno(duenoDB.getIdDueno());
                    setDireccion(duenoDB.getDireccion());
                    setNombre(duenoDB.getNombre());
                }};

                PacienteVo pacienteVo = new PacienteVo(){{
                    setIdPaciente(pacienteDB.getIdPaciente());
                    setNombre(pacienteDB.getNombre());
                    setComentarios(pacienteDB.getComentarios());
                    setCatEspecieIdEspecie(pacienteDB.getCatEspecie().getIdEspecie());
                    setCatEspecieNombre(pacienteDB.getCatEspecie().getNombre());
                    setDuenoVo(duenoVo);
                }};

                pacientes.add(pacienteVo);
            });

            response.setPacientes(pacientes);
            response.setCode("OK");
            response.setMessage("Se realizo correctamente");

        }catch (Exception e){
            System.out.println("Ocurrio un error al obtener los pacientes");
            response.setCode("ERROR");
            response.setMessage("Ocurrio un error");
        }

        return response;
    }
}
