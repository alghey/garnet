package mx.com.garnet.test;

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

import java.util.Objects;
import java.util.Optional;

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

    //@Test
    public void listAllEspecialidad(){

        Iterable<CatEspecialidad> especialidades = especialidadRepository.findAll();

        especialidades.forEach(especialidad->{
            System.out.println("Id " + especialidad.getIdEspecialidad());
            System.out.println("Nombre " + especialidad.getNombre());
        });
    }

    @Test
    public void findByIdEspecialidad(){

        Optional<CatEspecialidad> especialidad = especialidadRepository.findById(20);
/*
        try{
            System.out.println("Id ");
            System.out.println("Nombre " + especialidad.get().getNombre());
        }catch (Exception e){
            System.out.println("No se encontraron registros " + e);
        }
*/

       if(especialidad.isPresent()){
            System.out.println("Id " + especialidad.get().getIdEspecialidad());
            System.out.println("Nombre " + especialidad.get().getNombre());
        }else{
            System.out.println("No se encontraron registros");
        }
    }

    //@Test
    public void GuardarEspecialidad(){

        CatEspecialidad especialidad = new CatEspecialidad();
        especialidad.setNombre("Pediatria");

        especialidadRepository.save(especialidad);

        System.out.println("Id de la especialidad " + especialidad.getIdEspecialidad());


    }

    @Test
    public void ModificarEspecialidad() {

        Optional<CatEspecialidad> especialidad = especialidadRepository.findById(4);
        if (especialidad.isPresent()) {
            especialidad.get().setNombre("Fisioterapia");

            especialidadRepository.save(especialidad.get());

            System.out.println("el nombre de la especialidad con Id 5 es : " + especialidad.get().getNombre());
        }
    }


}
