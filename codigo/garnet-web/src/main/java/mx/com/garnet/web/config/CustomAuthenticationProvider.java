package mx.com.garnet.web.config;


import java.util.ArrayList;

import mx.com.garnet.web.AppConfigProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
    RestTemplate restTemplate;
	
	@Autowired
    AppConfigProperties appConfigProperties;

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);


	/**
	* Realiza la autenticacion (inicio de sesión)
	*
	* @param authentication El objeto de autenticacion del request
	* @param authentication the authentication request object.
	*
	* @return Objeto de autenticacion incluyendo credenciales, puede se rnulo en caso de no ser inicio de sesión  valido
	*
	* @throws AuthenticationException si la autenticacion falla.
	*/
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
/*
		String exceptionTrhowing=null;
		Authentication auth = null;
		
		
		try {

			//Obtiene la s credenciales del request
	        String name = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        //Construye objeto request para el consumo del servico login del api de servicios
	        LoginRequest loginRequest= new LoginRequest();
	      	byte[] pwBytes = DigestUtils.sha256("*" + password + ".");  // Se agrega * al inicio y . al final
	        loginRequest.setPassword(Base64.encodeBase64String(pwBytes));
	        loginRequest.setUsername(name);

	        logger.info("LoginRequest: " + loginRequest.toString());
	        
	        
	        // Realiza el consumo del servicio para inicio de sesión
		    LoginResponse response = new LoginResponse();
		    String UrlService = appConfigProperties.getServicesPath() + appConfigProperties.getLoginEndPoint();
		    response = restTemplate.postForObject(UrlService, loginRequest, LoginResponse.class);
		    logger.info("LoginResponse: " + response.toString());
	        
		    
	        //Si la respuesta no es nula inicializa la sesion y el objeto de la misma
			if(response!=null) {
				if(response.getResponseCode().equals(ResponseCode.OK.code)) {
					logger.info("Response OK");
					ArrayList<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
					grantedAuths.add(new SimpleGrantedAuthority("Administrador"));
                       
		        	auth = new UsernamePasswordAuthenticationToken(response.getLoginVo(), password, grantedAuths);
					return auth;
				}else {
					logger.info("Response != OK" + response.getResponseCode());

		        	exceptionTrhowing=response.getResponseCode();
				}
			}else {//Si la respuesta es nula y sin mensaje de respuesta se regresa mensaje de error generico de respuesta
	        	exceptionTrhowing="Error de autenticacion: "+"Sin respuesta del servidor";
	        }
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new BadCredentialsException("Error de autenticacion: "+"Sin respuesta del servidor");
		}
		if(exceptionTrhowing!=null){
			throw new BadCredentialsException(exceptionTrhowing);
		}
		else{
			return auth;
		}*/
	return null;
    }
	

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }



}
