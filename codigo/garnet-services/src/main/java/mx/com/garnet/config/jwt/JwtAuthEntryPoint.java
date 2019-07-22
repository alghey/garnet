package mx.com.garnet.config.jwt;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;



/**
* Maneja los errores de autenticacion y define que el error y descripcion a enviar al cliente
*
* @author  etorres
* @version 1.0
*/


@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);
    
    
    
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) 
                        		 throws IOException, ServletException {
    	if(e.getMessage()!="" && e.getMessage()!=null) {
            logger.error(e.getMessage());
    		response.sendError(HttpServletResponse.SC_OK, "Error -> "+e.getMessage());

    	}else {
    		logger.error("Unauthorized error. Message - {}", e.getMessage());
    		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
    	}
    }
}