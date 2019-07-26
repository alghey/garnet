package mx.com.garnet.services.paciente.impl;

import mx.com.garnet.common.dueno.dto.CrearDuenoRequest;
import mx.com.garnet.common.dueno.dto.CrearDuenoResponse;
import mx.com.garnet.common.pacientes.dto.CrearPacienteRequest;
import mx.com.garnet.common.pacientes.dto.CrearPacienteResponse;
import mx.com.garnet.common.pacientes.dto.ListaPacientesResponse;
import mx.com.garnet.common.pacientes.vo.DuenoVo;
import mx.com.garnet.common.pacientes.vo.PacienteVo;
import mx.com.garnet.persistence.entities.CatEspecie;
import mx.com.garnet.persistence.entities.DatDueno;
import mx.com.garnet.persistence.entities.DatPaciente;
import mx.com.garnet.persistence.repository.DuenoRepository;
import mx.com.garnet.persistence.repository.EspecieRepository;
import mx.com.garnet.persistence.repository.PacienteRepository;
import mx.com.garnet.services.paciente.DuenoService;
import mx.com.garnet.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("PacienteService")
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DuenoRepository duenoRepository;

    @Autowired
    DuenoService duenoService;

    @Autowired
    EspecieRepository especieRepository;

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

    @Override
    @Transactional
    public CrearPacienteResponse crearPaciente(CrearPacienteRequest request) {
        CrearPacienteResponse response = new CrearPacienteResponse();

        if(request == null || request.getPacienteVo() == null || request.getPacienteVo().getCatEspecieIdEspecie() == null){
            System.out.println("Los datos del request no son validos");
            response.setCode("ERROR REQUEST");
            response.setMessage("Error en el request");
        }else{
            PacienteVo pacienteVo = request.getPacienteVo();

            if(pacienteVo.getDuenoVo() == null || pacienteVo.getDuenoVo().getNombre() == null){
                System.out.println("Los datos del dueño no son validos");
                response.setCode("ERROR DUEÑO");
                response.setMessage("Error en el dueño");
            }else{
                DuenoVo duenoVo = pacienteVo.getDuenoVo();
                DatDueno duenoDB = new DatDueno();
                Boolean crearDuenoFlag = false;
                if(duenoVo.getIdDueno() == null){
                    crearDuenoFlag = true;
                }else{
                    //Si tiene id, se va a buscar
                   duenoDB = duenoRepository.findById(duenoVo.getIdDueno()).get();

                    if(duenoDB.getIdDueno() == null){
                        crearDuenoFlag = true;
                    }else{
                        crearDuenoFlag = false;
                    }
                }

                if(crearDuenoFlag){
                    duenoVo = crearDueno(duenoVo);
                    if(duenoVo != null){
                        duenoDB = duenoRepository.findById(duenoVo.getIdDueno()).get();
                    }
                }

                Optional<CatEspecie> especieDB = especieRepository.findById(pacienteVo.getCatEspecieIdEspecie());

                if(especieDB.isPresent()){
                    DatPaciente pacienteDB = new DatPaciente();
                    pacienteDB.setNombre(pacienteVo.getNombre());
                    pacienteDB.setComentarios(pacienteVo.getComentarios());
                    pacienteDB.setFechaAlta(new Date());
                    pacienteDB.setFechaNacimiento(pacienteVo.getFechaNacimiento());
                    pacienteDB.setFoto(pacienteVo.getFoto());
                    pacienteDB.setRaza(pacienteVo.getRaza());
                    pacienteDB.setSexo(pacienteVo.getSexo());
                    pacienteDB.setStatus(true);
                    pacienteDB.setDatDueno(duenoDB);
                    pacienteDB.setCatEspecie(especieDB.get());
                    pacienteDB.setNumeroRegistro("P001");

                    pacienteRepository.save(pacienteDB);
                    pacienteVo.setIdPaciente(pacienteDB.getIdPaciente());
                    response.setPacienteVo(pacienteVo);
                    response.setCode("OK");
                    response.setMessage("Se creo correctamente el paciente");
                }else{
                    System.out.println("Error al obtener la especie");
                }
            }
        }

        return response;
    }

    private DuenoVo crearDueno(DuenoVo duenoVo){
        // No tiene id, por lo tanto se crea un nuevo dueño
        CrearDuenoRequest crearDuenoReq = new CrearDuenoRequest(){{
            setDuenoVo(duenoVo);
        }};

        CrearDuenoResponse crearDuenoRes = duenoService.crearDueno(crearDuenoReq);

        if(crearDuenoRes.getCode().equals("OK")){
            //Se creo correctamente
            duenoVo.setIdDueno(crearDuenoRes.getDuenoVo().getIdDueno());
            return duenoVo;
        }else{
            System.out.println("Error al crear el dueño");
            return null;
        }
    }
}
