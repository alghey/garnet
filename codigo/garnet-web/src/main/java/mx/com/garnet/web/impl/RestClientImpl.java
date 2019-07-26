package mx.com.garnet.web.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import mx.com.garnet.web.config.CustomClientHttpRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* Implementacion para el consumo de web services por POST
*
* @author  etorres
* @version 1.0
*/


public class RestClientImpl{
	
	
    private static final Logger logger = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

	/**
	* Realia el consumo de web services a traves de POST
	*
	* @param  contenido Request que se envia al servicio, en formato String
	* @param  ruta Enponit del servicio a consumir
	* 
	* @return La respuesta del web services como Stirng
	* 
	*/
	public String  POST(String contenido,String ruta){
		
		StringBuffer respuesta = new StringBuffer();
		try {
		
			//Configura conexion,headers y parametros para el consumio via POST
			URL url = new URL(ruta);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Accept" , "application/json");
			String input = contenido;
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();
	  
			//Paresea respuesta a String
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream()),Charset.forName("UTF-8")));
	 
			String output;
			while ((output = br.readLine()) != null) {
				respuesta.append(output);
			}
			conn.disconnect();
			
		  } catch (MalformedURLException e) {
			logger.error(e.getMessage());
		  } catch (IOException e) {
			logger.error(e.getMessage());
		 }
		return respuesta.toString();
	}
	
}
