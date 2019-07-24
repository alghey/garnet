package mx.com.garnet;

import mx.com.garnet.persistence.entities.CatEspecialidad;
import mx.com.garnet.persistence.repository.EspecialidadRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ComponentScan("mx.com.garnet")
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
@ActiveProfiles("STANDALONE")
public class EspecialidadRepositoryTest {

    @Autowired
    EspecialidadRepository especialidadRepository;

    @Test
    public void listAllEspecialidad(){

        Iterable<CatEspecialidad> especialidades = especialidadRepository.findAll();

        especialidades.forEach(especialidad->{
            System.out.println("Id " + especialidad.getIdEspecialidad());
            System.out.println("Nombre " + especialidad.getNombre());
        });
    }

}
