package mx.com.garnet.common.response.catalogs;


import mx.com.garnet.common.vo.catalogs.CatPreguntaSecretaVo;
import mx.com.garnet.common.response.GeneralResponse;

import java.util.ArrayList;

public class CatPreguntaSecretaResponse extends GeneralResponse {

	ArrayList<CatPreguntaSecretaVo> preguntasSecretas;
	Integer size;
	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public ArrayList<CatPreguntaSecretaVo> getPreguntasSecretas() {
		return preguntasSecretas;
	}

	public void setPreguntasSecretas(ArrayList<CatPreguntaSecretaVo> preguntasSecretas) {
		this.preguntasSecretas = preguntasSecretas;
	}


	
	
}
