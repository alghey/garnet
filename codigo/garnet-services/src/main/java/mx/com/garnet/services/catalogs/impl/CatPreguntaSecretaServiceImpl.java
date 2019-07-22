package mx.com.garnet.services.catalogs.impl;

import mx.com.garnet.common.ResponseCode;
import mx.com.garnet.common.response.catalogs.CatPreguntaSecretaResponse;
import mx.com.garnet.common.vo.catalogs.CatPreguntaSecretaVo;
import mx.com.garnet.persistence.repository.cat.CatPreguntaSecretaRepository;
import mx.com.garnet.services.catalogs.CatPreguntaSecretaService;
import mx.com.garnet.persistence.entities.CatPreguntaSecreta;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CatPreguntaSecretaServiceImpl implements CatPreguntaSecretaService {

    @Autowired
    CatPreguntaSecretaRepository catPreguntaSecretaRepository;

    ModelMapper mapper = new ModelMapper();

    // CatPreguntaSecretaRepository repository = new CatPreguntaSecretaRepository();

    @Override
    public CatPreguntaSecretaResponse obtenerPreguntasSecretas() {
        CatPreguntaSecretaResponse response = new CatPreguntaSecretaResponse();

        ArrayList<CatPreguntaSecreta> preguntas = catPreguntaSecretaRepository.findAll();
        ArrayList<CatPreguntaSecretaVo> arrayVo = new ArrayList<CatPreguntaSecretaVo>();
        
        if(preguntas != null && preguntas.size() > 0){
            preguntas.forEach(pregunta -> {
                CatPreguntaSecretaVo preguntaSecretaVo = mapper.map(pregunta, CatPreguntaSecretaVo.class);
                arrayVo.add(preguntaSecretaVo);
            });
            response.setPreguntasSecretas(arrayVo);
            response.setSize(preguntas.size());
            response.setCode(ResponseCode.OK.code);
            response.setMessage(ResponseCode.OK.desc);
        }else{
            response.setCode(ResponseCode.CATALOG_EMPTY.code);
            response.setMessage(ResponseCode.CATALOG_EMPTY.desc);
        }
        return response;
    }
}
