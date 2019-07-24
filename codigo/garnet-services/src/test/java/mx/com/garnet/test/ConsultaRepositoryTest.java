package mx.com.garnet.test;

import mx.com.garnet.persistence.entities.DatConsulta;
import mx.com.garnet.persistence.entities.DatMedico;
import mx.com.garnet.persistence.repository.ConsultaRepository;
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
public class ConsultaRepositoryTest {

    @Autowired
    ConsultaRepository consultaRepository;

    @Test
    public void buscarPorMedico(){
        DatMedico medico = new DatMedico();
        medico.setIdMedico(1);

        List<DatConsulta> consultas = consultaRepository.findAllByDatMedico(medico);

        if(consultas.size() > 0){
            consultas.forEach(consulta ->{
                System.out.println("Diagnostico: " + consulta.getDiagnostico());
                System.out.println("Paciente: " + consulta.getDatPaciente().getNombre());
                // System.out.println("Medico: " + consulta.getDatMedico().getNombre());
            });
        }else{
            System.out.println("No se encontraron registros");
        }
    }
}
