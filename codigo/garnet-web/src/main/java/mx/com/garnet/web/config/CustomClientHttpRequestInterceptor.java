package mx.com.garnet.web.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;



@Component
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

    /**
    * intercepta las peticiones , agrega elheader Authorization con el token JWT cumplir con la seguridad
    * de parte del api de web services
    *
	* @param request El request, el cual contine el metodo, endpont y headers
	* @param body el contenido del request
	* @param execution execution desde el contexto del request
	* @return La respuesta del execute
	* @throws IOException Si se tienen errores I/O errors
    */
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {		
		//Obtengo la sesion del contexto de Spring y en caso de existir se agrega el header 'Authorization' con el token JWT
		/*SecurityContext securityContext = SecurityContextHolder.getContext();
		 Authentication authentication = securityContext.getAuthentication();
		    if (authentication != null) {
		    	if(authentication.getPrincipal()!=null) {
		    		try {
					        LogInVo principal =(LogInVo)authentication.getPrincipal();
					        request.getHeaders().add("Authorization", principal.getTokenType()+" "+principal.getJwt());
							logger.info("AUTH [ " + principal.getTokenType()+" "+principal.getJwt() + " ] ");
		    		}catch(Exception ex) {
		    			
		    		}
		    	}
		       
		    }
		ClientHttpResponse response = execution.execute(request, body);*/
	    return null;
	}

}
