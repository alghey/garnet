package mx.com.garnet.persistence.repository.cat;

import mx.com.garnet.persistence.entities.CatPreguntaSecreta;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CatPreguntaSecretaRepository extends CrudRepository<CatPreguntaSecreta,Integer> {
    
	CatPreguntaSecreta findByIdPreguntaSecreta(Integer IdPreguntaSecreta);
    
	ArrayList<CatPreguntaSecreta> findAll();

	CatPreguntaSecreta findByPreguntaSecreta(String preguntaSecreta);

	ArrayList<CatPreguntaSecreta> findByNombreCategoria(String nombreCategoria);
}
