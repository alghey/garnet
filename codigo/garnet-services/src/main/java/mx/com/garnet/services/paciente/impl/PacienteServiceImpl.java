package mx.com.garnet.services.paciente.impl;

import mx.com.garnet.common.dueno.dto.CrearDuenoRequest;
import mx.com.garnet.common.dueno.dto.CrearDuenoResponse;
import mx.com.garnet.common.pacientes.dto.*;
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
import org.springframework.security.access.method.P;
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
    DuenoService duenoService;

    @Autowired
    DuenoRepository duenoRepository;

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
    public PacienteResponse listarPaciente(PacienteVo paciente){
        PacienteResponse response = new PacienteResponse();

        //PacienteVo paciente = new PacienteVo();
        Optional<DatPaciente> pacienteDB = pacienteRepository.findById(paciente.getIdPaciente());
        try{

            DatDueno duenoDB = pacienteDB.get().getDatDueno();
            DuenoVo duenoVo = new DuenoVo(){{
                setIdDueno(duenoDB.getIdDueno());
                setDireccion(duenoDB.getDireccion());
                setNombre(duenoDB.getNombre());
                setTelefono(duenoDB.getTelefono());
                setStatus(duenoDB.isStatus());
            }};

            PacienteVo pacienteVo = new PacienteVo(){{
                setIdPaciente(pacienteDB.get().getIdPaciente());
                setNombre(pacienteDB.get().getNombre());
                setRaza(pacienteDB.get().getRaza());
                setFechaNacimiento(pacienteDB.get().getFechaNacimiento());
                setStatus(pacienteDB.get().isStatus());
                setComentarios(pacienteDB.get().getComentarios());
                setSexo(pacienteDB.get().getSexo());
                setFoto(pacienteDB.get().getFoto());
                setFechaAlta(pacienteDB.get().getFechaAlta());
                setNumeroRegistro(pacienteDB.get().getNumeroRegistro());
                setCatEspecieIdEspecie(pacienteDB.get().getCatEspecie().getIdEspecie());
                setCatEspecieNombre(pacienteDB.get().getCatEspecie().getNombre());
                setDuenoVo(duenoVo);
            }};

            //pacientes.add(pacienteVo);


            response.setPaciente(pacienteVo);
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
    public PacienteResponse modificarPaciente(PacienteVo paciente){
        PacienteResponse response = new PacienteResponse();

        //PacienteVo paciente = new PacienteVo();
        Optional<DatPaciente> pacienteDB = pacienteRepository.findById(paciente.getIdPaciente());

        if(pacienteDB.isPresent()){
            pacienteDB.get().setNombre(paciente.getNombre());
            pacienteDB.get().setRaza(paciente.getRaza());
            pacienteDB.get().setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteDB.get().setStatus(paciente.isStatus());
            pacienteDB.get().setComentarios(paciente.getComentarios());
            pacienteDB.get().setSexo(paciente.getSexo());
            pacienteDB.get().setFoto(paciente.getFoto());
            pacienteDB.get().setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteDB.get().setNumeroRegistro(paciente.getNombre());
            pacienteDB.get().getCatEspecie().setIdEspecie(paciente.getCatEspecieIdEspecie());
            //pacienteDB.get().getCatEspecie().setNombre(paciente.getCatEspecieNombre());
            pacienteDB.get().getDatDueno().setIdDueno(paciente.getDuenoVo().getIdDueno());

            pacienteRepository.save(pacienteDB.get());
            //especialidad.get().setNombre("Fisioterapia");
            //especialidadRepository.save(especialidad.get());
            //System.out.println("El nombre de la especialidad con id 4 es: " + especialidad.get().getNombre());
        }else {
            System.out.println("ID no encontrado");
            response.setCode("ID FAILED");
            response.setMessage("Ocurrio un error al buscar el ID");

            return response;
        }


        Optional<DatPaciente> pacienteRF = pacienteRepository.findById(paciente.getIdPaciente());
        try{

            DatDueno duenoRF = pacienteDB.get().getDatDueno();
            DuenoVo duenoVo = new DuenoVo(){{
                setIdDueno(duenoRF.getIdDueno());
                setDireccion(duenoRF.getDireccion());
                setNombre(duenoRF.getNombre());
                setTelefono(duenoRF.getTelefono());
                setStatus(duenoRF.isStatus());
            }};

            PacienteVo pacienteVo = new PacienteVo(){{
                setIdPaciente(pacienteRF.get().getIdPaciente());
                setNombre(pacienteRF.get().getNombre());
                setRaza(pacienteRF.get().getRaza());
                setFechaNacimiento(pacienteRF.get().getFechaNacimiento());
                setStatus(pacienteRF.get().isStatus());
                setComentarios(pacienteRF.get().getComentarios());
                setSexo(pacienteRF.get().getSexo());
                setFoto(pacienteRF.get().getFoto());
                setFechaAlta(pacienteRF.get().getFechaAlta());
                setNumeroRegistro(pacienteRF.get().getNumeroRegistro());
                setCatEspecieIdEspecie(pacienteRF.get().getCatEspecie().getIdEspecie());
                setCatEspecieNombre(pacienteRF.get().getCatEspecie().getNombre());
                setDuenoVo(duenoVo);
            }};

            //pacientes.add(pacienteVo);


            response.setPaciente(pacienteVo);
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
                }
                else{
                    // si tiene id, ve a buscarlo
                    duenoDB = duenoRepository.findById(duenoVo.getIdDueno()).get();
                    if(duenoDB.getIdDueno() == null){
                        crearDuenoFlag = true;
                    }else{
                        crearDuenoFlag =false;

                }

                if(crearDuenoFlag){
                    duenoVo = creaDueno(duenoVo);

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
                    pacienteDB.setSexo(pacienteVo.getSexo());
                    pacienteDB.setFoto(pacienteVo.getFoto());
                    pacienteDB.setRaza(pacienteVo.getRaza());
                    pacienteDB.setStatus(true);
                    pacienteDB.setDatDueno(duenoDB);
                    pacienteDB.setCatEspecie(especieDB.get());
                    pacienteDB.setNumeroRegistro("p001");

                    pacienteRepository.save(pacienteDB);
                    pacienteVo.setIdPaciente(pacienteDB.getIdPaciente());
                    response.setPacienteVo(pacienteVo);
                    response.setCode("OK");
                    response.setMessage("Se creo correctamente el paciente");
                }else{
                    System.out.println("Error al obtener especie");
                    response.setCode("ERROR ESPECIE");
                    response.setMessage("Error en la especie");
                }


            }
        }

        return response;
    }

    private DuenoVo crearDueno(DuenoVo duenoVo){
        // No tiene id , por lo tanto se crea un nuevo dueño
        CrearDuenoRequest crearDuenoRequest = new CrearDuenoRequest(){{
            setDuenoVo(duenoVo);
        }};

        CrearDuenoResponse crearDuenoResponse = duenoService.crearDueno(crearDuenoRequest);

        if(crearDuenoResponse.getCode().equals("OK")){
            // se creo correctamente
            duenoVo.setIdDueno(crearDuenoResponse.getDuenoVo().getIdDueno());

            return duenoVo;
        }else{
            System.out.println("Error al crear el dueño");
            return null;
        }
    }
}

