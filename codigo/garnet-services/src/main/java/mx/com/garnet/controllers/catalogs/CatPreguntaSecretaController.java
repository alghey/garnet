package mx.com.garnet.controllers.catalogs;

import mx.com.garnet.common.response.catalogs.CatPreguntaSecretaResponse;
import mx.com.garnet.services.catalogs.CatPreguntaSecretaService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cat")
public class CatPreguntaSecretaController {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    CatPreguntaSecretaService catPreguntaSecretaService;

    @GetMapping("/preguntasSecretas")
    public CatPreguntaSecretaResponse getPreguntasSecretas() {
        logger.info("===>Se obtienen las preguntas secretas.<===");
        return catPreguntaSecretaService.obtenerPreguntasSecretas();
    }
    @GetMapping("/preguntasSecretas")
    public CatPreguntaSecretaResponse getPreguntasSecretas() {
        logger.info("===>Se obtienen las preguntas secretas.<===");
        return catPreguntaSecretaService.obtenerPreguntasSecretas();
    }
    @GetMapping("/preguntasSecretas")
    public CatPreguntaSecretaResponse getPreguntasSecretas() {
        logger.info("===>Se obtienen las preguntas secretas.<===");
        return catPreguntaSecretaService.obtenerPreguntasSecretas();
    }
        
}
