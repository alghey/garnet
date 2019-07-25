package mx.com.garnet.services.paciente.impl;

import mx.com.garnet.common.dueno.dto.CrearDuenoRequest;
import mx.com.garnet.common.dueno.dto.CrearDuenoResponse;
import mx.com.garnet.common.pacientes.vo.DuenoVo;
import mx.com.garnet.persistence.entities.DatDueno;
import mx.com.garnet.persistence.repository.DuenoRepository;
import mx.com.garnet.services.paciente.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DuenoService")
public class DuenoServiceImpl implements DuenoService {

    @Autowired
    DuenoRepository duenoRepository;

    @Override
    @Transactional
    public CrearDuenoResponse crearDueno(CrearDuenoRequest request) {
        CrearDuenoResponse response = new CrearDuenoResponse();

        if(request == null || request.getDuenoVo() == null){
            System.out.println("El request no es valido");
            response.setCode("ERROR REQUEST");
            response.setMessage("Request no valido");
        }else{
            DuenoVo duenoVo = request.getDuenoVo();

            DatDueno dueno = new DatDueno();
            dueno.setNombre(duenoVo.getNombre());
            dueno.setTelefono(duenoVo.getTelefono());
            dueno.setDireccion(duenoVo.getDireccion());
            dueno.setStatus(true);

            try{
                duenoRepository.save(dueno);
                System.out.println("ID del nuevo dueño" + dueno.getIdDueno());
                duenoVo.setIdDueno(dueno.getIdDueno());
                response.setDuenoVo(duenoVo);
                response.setCode("OK");
                response.setMessage("Se creo correctamente ;D");
            }catch (Exception e){
                System.out.println("Erros al crear el dueño");
                e.printStackTrace();
                response.setCode("ERROR CREAR");
                response.setMessage("Error al crear el dueño");
            }

        }

        return response;
    }
}
